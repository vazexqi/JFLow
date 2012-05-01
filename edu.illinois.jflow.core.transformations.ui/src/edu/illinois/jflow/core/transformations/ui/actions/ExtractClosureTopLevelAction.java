package edu.illinois.jflow.core.transformations.ui.actions;

import org.eclipse.jdt.internal.ui.actions.SelectionConverter;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.jdt.internal.ui.refactoring.actions.RefactoringStarter;
import org.eclipse.jdt.ui.refactoring.RefactoringSaveHelper;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;

import edu.illinois.jflow.core.transformations.code.ExtractClosureRefactoring;
import edu.illinois.jflow.core.transformations.ui.JFlowRefactoringMessages;
import edu.illinois.jflow.core.transformations.ui.refactoring.ExtractClosureWizard;

/**
 * Action to invoke our Extract Closure Refactoring
 * 
 * @author Nicholas Chen
 * 
 */
@SuppressWarnings("restriction")
public class ExtractClosureTopLevelAction extends JFlowRefactoringAction {

	@Override
	protected void startTextSelectionRefactoring(IEditorPart activeEditor, JavaEditor javaEditor, ISelection selection) {
		ITextSelection textSelection= (ITextSelection)selection;

		Shell shell= activeEditor.getSite().getShell();
		ExtractClosureRefactoring refactoring= new ExtractClosureRefactoring(SelectionConverter.getInputAsCompilationUnit(javaEditor), textSelection.getOffset(), textSelection.getLength());
		new RefactoringStarter().activate(new ExtractClosureWizard(refactoring), shell, JFlowRefactoringMessages.ExtractClosureAction_dialog_title, RefactoringSaveHelper.SAVE_NOTHING);
	}
}
