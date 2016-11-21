import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class ModelEvaluation {
    public void evaluateModel(Instances trainingSet,Instances validationSet, J48 j48Tree){
        try {
            Evaluation evaluation = new Evaluation(trainingSet);
            evaluation.evaluateModel(j48Tree,validationSet);
            System.out.println(evaluation.toSummaryString("=======Evaluation Results=======\n",false));
            System.out.println("Error Rate = " + evaluation.errorRate());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
