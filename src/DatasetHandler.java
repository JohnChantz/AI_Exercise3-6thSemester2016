import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatasetHandler {

    private Instances dataset = null;
    private Instances trainingSet = null;
    private Instances validationSet = null;

    private double percentage = 75.0;       //dataset split percentage
    private int trainSize = 0;
    private int validationSize = 0;

    public DatasetHandler() {
        dataset = loadDataset();
        createTrainingSet();
        createValidationSet();
    }


    private Instances loadDataset() {
        try {
            dataset = new Instances(new BufferedReader(new FileReader("C:\\Users\\John Ch\\IdeaProjects\\AI_Exercise3\\resources\\letter-recognition.arff")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dataset.toSummaryString());
        return dataset;
    }

    private void createTrainingSet() {
        trainSize = (int) Math.round(dataset.numInstances() * percentage / 100);
        trainingSet = new Instances(dataset, 0, trainSize);
    }

    private void createValidationSet() {
        validationSize = dataset.numInstances() - trainSize;
        validationSet = new Instances(dataset, trainSize, validationSize);
    }

    public Instances getDataset() {
        return dataset;
    }

    public void setDataset(Instances dataset) {
        this.dataset = dataset;
    }

    public Instances getTrainingSet() {
        return trainingSet;
    }

    public void setTrainingSet(Instances trainingSet) {
        this.trainingSet = trainingSet;
    }

    public Instances getValidationSet() {
        return validationSet;
    }

    public void setValidationSet(Instances validationSet) {
        this.validationSet = validationSet;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getTrainSize() {
        return trainSize;
    }

    public void setTrainSize(int trainSize) {
        this.trainSize = trainSize;
    }

    public int getValidationSize() {
        return validationSize;
    }

    public void setValidationSize(int validationSize) {
        this.validationSize = validationSize;
    }
}
