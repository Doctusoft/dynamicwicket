package com.dynamicwicket.form.core.metacontextprocessor;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

import com.dynamicwicket.core.MetaComponent;
import com.dynamicwicket.core.behavior.TableCellBehavior;
import com.dynamicwicket.form.component.AbstractDynamicFormComponent;

public class TableCellMetaContextProcessor extends AbstractDefaultMetaContextProcessor {

	@Override
	protected void processMetaComponent(MetaComponent metaComponent) {
		Component componentInstance = metaComponent.getComponentInstance();
		if (componentInstance != null && componentInstance instanceof AbstractDynamicFormComponent<?>) {
			AbstractDynamicFormComponent<?> formComponent = (AbstractDynamicFormComponent<?>) componentInstance;
			formComponent.visitChildren(new IVisitor<Component, Void>() {

				@Override
				public void component(Component component, IVisit<Void> arg1) {
					if (component instanceof Label || component instanceof FormComponent<?>) {
						component.add(new TableCellBehavior());
					}
				}

			});
		}
	}

}
