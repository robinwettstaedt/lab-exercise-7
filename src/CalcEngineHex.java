


public class CalcEngineHex extends CalcEngine {



    public CalcEngineHex() {
        super();
    }



    public void numberPressed(int number) {

        if(buildingDisplayValue) {
            // Incorporate this digit.
            if (getIsDecCalcValue()) {
                displayValue = displayValue * 10 + number;
            }
            else {
                displayValue = displayValue * 16 + number;
            }
        }
        else {
            // Start building a new number.
            displayValue = number;
            buildingDisplayValue = true;
        }
    }
}
