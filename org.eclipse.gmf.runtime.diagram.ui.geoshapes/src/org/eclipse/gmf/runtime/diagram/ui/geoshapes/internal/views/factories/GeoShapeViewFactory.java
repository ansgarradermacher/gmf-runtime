/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.diagram.ui.geoshapes.internal.views.factories;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.IPreferenceConstants;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.TextShapeViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.View;

/**
 * The GeoShapeView Factory class
 * 
 * @author mmostafa
 */
public class GeoShapeViewFactory
	extends TextShapeViewFactory {

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.internal.view.AbstractView#initializeFromPreferences(org.eclipse.jface.preference.IPreferenceStore)
	 */
	protected void initializeFromPreferences(View view) {
		super.initializeFromPreferences(view);

		IPreferenceStore store = (IPreferenceStore) getPreferencesHint().getPreferenceStore();

		// fill color
		RGB fillRGB = PreferenceConverter.getColor(store,
			IPreferenceConstants.PREF_NOTE_FILL_COLOR);
		ViewUtil.setPropertyValue(view, Properties.ID_FILLCOLOR,
			FigureUtilities.RGBToInteger(fillRGB));

		//line color
		RGB lineRGB = PreferenceConverter.getColor(store,
			IPreferenceConstants.PREF_NOTE_LINE_COLOR);
		ViewUtil.setPropertyValue(view, Properties.ID_LINECOLOR,
			FigureUtilities.RGBToInteger(lineRGB));
	}
}