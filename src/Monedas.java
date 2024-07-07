public record Monedas(String base_code, String target_code,double conversion_result) {

    @Override
    public String toString() {
        return "[" + base_code + "]" + "Corresponde a $ " + conversion_result + "[" + target_code + "]";
    }
}
