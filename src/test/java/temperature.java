public class temperature {


    interface Converter {
        double getConvertedValue(double baseValue);
    }

    static class CelsiusConverter implements Converter {
        @Override
        public double getConvertedValue(double baseValue) {
            return baseValue;
        }
    }

    static class KelvinConverter implements Converter {

        @Override
        public double getConvertedValue(double baseValue) {
            return baseValue + 273.15;
        }
    }

    static class FahrenheitConverter implements Converter {
        @Override
        public double getConvertedValue(double baseValue) {
            return 1.8 * baseValue + 32;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            double temperature = 23.5;
            System.out.println("t = " +
                    new CelsiusConverter().getConvertedValue(temperature));
            System.out.println("t = " +
                    new KelvinConverter().getConvertedValue(temperature));
            System.out.println("t = " +
                    new FahrenheitConverter().getConvertedValue(temperature));
        }
    }

}
