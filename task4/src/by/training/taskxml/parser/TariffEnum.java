package by.training.taskxml.parser.saxbuilder;

public enum TariffEnum {

    TARIFFS("tariffs"),
    FINISH("finish"),
    SMARTPHONE("smartphone"),
    INTERNET("internet"),
    ONLY_CALLS("only_calls"),
    CALL_PRICES("call_prices"),
    PARAMETERS("parameters"),
    IDNUMBER("idnumber"),
    TARIFFING("tariffing"),
    NAME("name"),
    OPERATOR_NAME("operator_name"),
    PAYROLL("payroll"),
    DATE("date"),
    START("start"),
    INSIDE("inside"),
    OUTSIDE("outside"),
    LANDLINE("landline"),
    SMS("sms"),
    FREE_MINUTE("free_minute"),
    INTERNET_PRICE("internet_price"),
    FREE_MGB("free_mgb"),
    FAVORITE_NUMBER("favorite_number"),
    CONNECTION_FEE("connection_fee");

    private String value;

    private TariffEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
