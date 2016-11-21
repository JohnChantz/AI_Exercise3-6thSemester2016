public class Main {
    public static void main(String[] args) {
        DatasetHandler datasetHandler = new DatasetHandler();

        Classification classification = new Classification(datasetHandler.getTrainingSet(), datasetHandler.getValidationSet());

        classification.startClassification();
    }
}