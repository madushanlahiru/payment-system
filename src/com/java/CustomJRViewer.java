/*
 * The MIT License
 *
 * Copyright 2023 SandBox.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.java;

import java.util.Locale;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.swing.JRViewerToolbar;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.save.JRDocxSaveContributor;
import net.sf.jasperreports.view.save.JRPdfSaveContributor;
import net.sf.jasperreports.view.save.JRRtfSaveContributor;
import net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor;

/**
 *
 * @author SandBox
 */
public class CustomJRViewer extends JRViewer {
    //define the constructor that you use
    public CustomJRViewer(JasperPrint jasperPrint) {
        super(jasperPrint);
    }

    @Override
    protected JRViewerToolbar createToolbar() {
        JRViewerToolbar toolbar = super.createToolbar();

        Locale locale = viewerContext.getLocale();
        ResourceBundle resBundle = viewerContext.getResourceBundle();
        JRPdfSaveContributor pdf = new JRPdfSaveContributor(locale, resBundle);
        JRRtfSaveContributor rtf = new JRRtfSaveContributor(locale, resBundle);
        JRSingleSheetXlsSaveContributor xls = new JRSingleSheetXlsSaveContributor(locale, resBundle);
        JRDocxSaveContributor docx = new JRDocxSaveContributor(locale, resBundle);
        toolbar.setSaveContributors(new JRSaveContributor[] {pdf, rtf, xls, docx});

        return toolbar;
    }   
}
