import weka.classifiers.trees.J48;
import weka.core.Instances;

public class Classification {

    private Instances trainingSet = null;
    private Instances validationSet = null;
    J48 j48Tree = null;

    public Classification(Instances trainingSet, Instances validationSet) {
        this.trainingSet = trainingSet;
        this.validationSet = validationSet;
    }

    public void startClassification() {
        createClassifier();
        ModelEvaluation modelEvaluation = new ModelEvaluation();
        modelEvaluation.evaluateModel(trainingSet, validationSet, j48Tree);
    }

    private void createClassifier() {
        trainingSet.setClassIndex(0);
        String[] options = new String[4];
        options[0] = "-C";
        options[1] = "0.25";
        options[2] = "-M";
        options[3] = "2";
        j48Tree = new J48();
        try {
            j48Tree.setOptions(options);
            j48Tree.buildClassifier(trainingSet);

        } catch (Exception e) {
            e.printStackTrace();
        }
        validationSet.setClassIndex(0);
    }
}
