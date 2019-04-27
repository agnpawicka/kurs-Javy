import javax.swing.*;

public class SpinnerForMonths extends SpinnerListModel {
    private String firstValue, lastValue;
    private SpinnerModel linkedModel = null;
    public SpinnerForMonths(String[] values) {
        super(values);
        firstValue = values[0];
        lastValue = values[values.length - 1];
    }
    public void setLinkedModel(SpinnerModel linkedModel) {
        this.linkedModel = linkedModel;
    }

    public Object getNextValue() {
        Object value = super.getNextValue();
        if (value == null) {
            value = firstValue;
            if (linkedModel != null) {
                linkedModel.setValue(linkedModel.getNextValue());
            }
        }
        return value;
    }

    public Object getPreviousValue() {
        Object value = super.getPreviousValue();
        if (value == null) {
            value = lastValue;
            if (linkedModel != null) {
                linkedModel.setValue(linkedModel.getPreviousValue());
            }
        }
        return value;
    }
}
