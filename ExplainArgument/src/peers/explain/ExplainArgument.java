package peers.explain;

import java.util.HashMap;
import java.util.Map;

public class ExplainArgument {
    enum type {
        ARGN,
        ARGR,
        ARGE,
        ARGA,
    };
    static Map<String, type> argument;
    boolean openCreateExpression;
    boolean openCompareResult;
    int N;
    int R;
    String exerciseFile;
    String answerFile;
    public ExplainArgument(String[] args) {
        this.N = -1;
        this.R = -1;
        exerciseFile = null;
        answerFile = null;
        openCompareResult = false;
        openCreateExpression = false;
        argument = new HashMap<>();
        argument.put("-n", type.ARGN);
        argument.put("-r", type.ARGR);
        argument.put("-e", type.ARGE);
        argument.put("-a", type.ARGA);
        for(int i = 0; i < args.length; i++) {
            if(argument.containsKey(args[i])) {
                if(i + 1 < args.length){
                    explain(argument.get(args[i]), args[i+1]);
                    i++;
                }
            }
        }
        if(N > 0 && R > 0) {
            this.openCreateExpression = true;
        }
        if(exerciseFile != null && answerFile != null) {
            this.openCompareResult = true;
        }
    }
    private void explain(type argType, String x) {
        if(argType == type.ARGN) {
                this.N =  Integer.parseInt(x);
        }
        else if(argType == type.ARGR) {
            this.R = Integer.parseInt(x);
        }
        else if(argType == type.ARGE) {
            this.exerciseFile = x;
        }
        else if(argType == type.ARGA) {
            this.answerFile = x;
        }
    }
    public String getExerciseFile() {
        if(openCompareResult) {
            return exerciseFile;
        }
        return null;
    }
    public String getAnswerFile() {
        if(openCompareResult) {
            return answerFile;
        }
        return null;
    }
    public int getN() {
        if(openCreateExpression) {
            return N;
        }
        return 0;
    }
    public int getR() {
        if(openCreateExpression) {
            return R;
        }
        return 0;
    }
    public boolean isOpenCreateExpression() {
        return openCreateExpression;
    }
    public boolean isOpenCompareResult() {
        return openCompareResult;
    }

}
