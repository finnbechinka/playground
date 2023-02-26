//STAGE 1
package de.devboost.entwicklerheldchallenge;

import de.devboost.entwicklerheldchallenge.model.Assignment;
import de.devboost.entwicklerheldchallenge.model.CannotDoMuchProgram;
import de.devboost.entwicklerheldchallenge.model.Comparison;
import de.devboost.entwicklerheldchallenge.model.ComparisonOperator;
import de.devboost.entwicklerheldchallenge.model.Expression;
import de.devboost.entwicklerheldchallenge.model.IfStatement;
import de.devboost.entwicklerheldchallenge.model.IntegerInput;
import de.devboost.entwicklerheldchallenge.model.IntegerLiteral;
import de.devboost.entwicklerheldchallenge.model.Statement;
import de.devboost.entwicklerheldchallenge.model.VariableReference;

public class CannotDoMuchProgramAnalyzer {

    public boolean analyze(CannotDoMuchProgram program, String variableName, int value) {
        // TODO Do something smart here to analyze the program
        for(Statement curr : program.getStatements()){
            if(curr instanceof Assignment){
                Assignment tmp = (Assignment)curr;
                if(tmp.getVariableName() == variableName){
                    Expression ex = tmp.getExpression();
                    if(ex instanceof IntegerLiteral){
                        IntegerLiteral il = (IntegerLiteral)ex;
                        if(il.getValue() == value){
                            return true;
                        }else{
                            return false;
                        }
                    }else if(ex instanceof VariableReference){
                        VariableReference vr = (VariableReference)ex;
                        return analyze(program, vr.getVariableName(), value);
                    }
                }
            }
        }
        return false;
    }
}

//STAGE 2
package de.devboost.entwicklerheldchallenge;

import java.util.HashMap;

import de.devboost.entwicklerheldchallenge.model.Assignment;
import de.devboost.entwicklerheldchallenge.model.CannotDoMuchProgram;
import de.devboost.entwicklerheldchallenge.model.Comparison;
import de.devboost.entwicklerheldchallenge.model.ComparisonOperator;
import de.devboost.entwicklerheldchallenge.model.Expression;
import de.devboost.entwicklerheldchallenge.model.IfStatement;
import de.devboost.entwicklerheldchallenge.model.IntegerInput;
import de.devboost.entwicklerheldchallenge.model.IntegerLiteral;
import de.devboost.entwicklerheldchallenge.model.Statement;
import de.devboost.entwicklerheldchallenge.model.VariableReference;

public class CannotDoMuchProgramAnalyzer {

    public boolean analyze(CannotDoMuchProgram program, String variableName, int value) {
        // TODO Do something smart here to analyze the program
        HashMap<String, Integer> variables = new HashMap<>();
        for (Statement curr : program.getStatements()) {
            System.out.println(curr);
            if (curr instanceof Assignment) {
                Assignment tmp = (Assignment) curr;
                variables = doAssignment(tmp, variables);
            } else if (curr instanceof IfStatement) {
                IfStatement is = (IfStatement) curr;
                Comparison comp = is.getComparison();
                int left;
                int right;
                if (comp.getLeft() instanceof IntegerLiteral) {
                    left = ((IntegerLiteral) comp.getLeft()).getValue();
                } else {
                    left = variables.get(((VariableReference) comp.getLeft()).getVariableName());
                }
                if (comp.getRight() instanceof IntegerLiteral) {
                    right = ((IntegerLiteral) comp.getRight()).getValue();
                } else {
                    right = variables.get(((VariableReference) comp.getRight()).getVariableName());
                }
                
                ComparisonOperator co = comp.getOperator();
                if (co.equals(ComparisonOperator.LESS_THAN)) {
                    if (left < right) {
                        Statement ibs = is.getIfBranch();
                        if (ibs instanceof Assignment) {
                            Assignment tmp = (Assignment) ibs;
                            variables = doAssignment(tmp, variables);
                        }
                    } else {
                        Statement ebs = is.getElseBranch();
                        if (ebs instanceof Assignment) {
                            Assignment tmp = (Assignment)ebs;
                            variables = doAssignment(tmp, variables);
                        }
                    }
                }
            }
        }

        if (variables.containsKey(variableName) && variables.get(variableName) == value) {
            return true;
        } else {
            return false;
        }
    }

    public HashMap<String, Integer> doAssignment(Assignment assignment, HashMap<String, Integer> variables) {
        Expression ex = assignment.getExpression();
        if (ex instanceof IntegerLiteral) {
            IntegerLiteral il = (IntegerLiteral) ex;
            variables.put(assignment.getVariableName(), il.getValue());
        } else if (ex instanceof VariableReference) {
            VariableReference vr = (VariableReference) ex;
            variables.put(assignment.getVariableName(), variables.get(vr.getVariableName()));
        }
        return variables;
    }
}


//STAGE 3
