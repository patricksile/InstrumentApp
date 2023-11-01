import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Enumerations
enum Type { SQUARE_NECK, ROUNDNECK, BLUEGRASS, TENOR, PLECTRUM, ELECTRIC, ACOUSTIC, ELECTRIC_BASS }
enum Size { SIZE_44, SIZE_34, SIZE_12, SIZE_14 }
enum BodyType { A_STYLE, F_STYLE }

// Interfaces
interface InstrumentSpec {
    boolean matches(InstrumentSpec otherSpec);
}

interface StringedInstrument {
    double getPrice();
    String getSerialNumber();
    InstrumentSpec getSpec();
}

// Implementations for Dobro
class DobroSpec implements InstrumentSpec {
    private Type type;

    public DobroSpec(Type type) {
        this.type = type;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!(otherSpec instanceof DobroSpec)) return false;
        DobroSpec spec = (DobroSpec) otherSpec;
        return type == spec.type;
    }
}

class Dobro implements StringedInstrument {
    private String serialNumber;
    private double price;
    private DobroSpec spec;

    public Dobro(String serialNumber, double price, DobroSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public double getPrice() { return price; }
    public String getSerialNumber() { return serialNumber; }
    public InstrumentSpec getSpec() { return spec; }
}

// Implementations for Banjo
class BanjoSpec implements InstrumentSpec {
    private Type type;

    public BanjoSpec(Type type) {
        this.type = type;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!(otherSpec instanceof BanjoSpec)) return false;
        BanjoSpec spec = (BanjoSpec) otherSpec;
        return type == spec.type;
    }
}

class Banjo implements StringedInstrument {
    private String serialNumber;
    private double price;
    private BanjoSpec spec;

    public Banjo(String serialNumber, double price, BanjoSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public double getPrice() { return price; }
    public String getSerialNumber() { return serialNumber; }
    public InstrumentSpec getSpec() { return spec; }
}

// Implementations for Bass
class BassSpec implements InstrumentSpec {
    private Type type;

    public BassSpec(Type type) {
        this.type = type;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!(otherSpec instanceof BassSpec)) return false;
        BassSpec spec = (BassSpec) otherSpec;
        return type == spec.type;
    }
}

class Bass implements StringedInstrument {
    private String serialNumber;
    private double price;
    private BassSpec spec;

    public Bass(String serialNumber, double price, BassSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public double getPrice() { return price; }
    public String getSerialNumber() { return serialNumber; }
    public InstrumentSpec getSpec() { return spec; }
}

// Implementations for Fiddle
class FiddleSpec implements InstrumentSpec {
    private Size size;

    public FiddleSpec(Size size) {
        this.size = size;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!(otherSpec instanceof FiddleSpec)) return false;
        FiddleSpec spec = (FiddleSpec) otherSpec;
        return size == spec.size;
    }
}

class Fiddle implements StringedInstrument {
    private String serialNumber;
    private double price;
    private FiddleSpec spec;

    public Fiddle(String serialNumber, double price, FiddleSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public double getPrice() { return price; }
    public String getSerialNumber() { return serialNumber; }
    public InstrumentSpec getSpec() { return spec; }
}
// Implementations for Guitar
class GuitarSpec implements InstrumentSpec {
    private Type type;

    public GuitarSpec(Type type) {
        this.type = type;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!(otherSpec instanceof GuitarSpec)) return false;
        GuitarSpec spec = (GuitarSpec) otherSpec;
        return type == spec.type;
    }
}

class Guitar implements StringedInstrument {
    private String serialNumber;
    private double price;
    private GuitarSpec spec;

    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public double getPrice() { return price; }
    public String getSerialNumber() { return serialNumber; }
    public InstrumentSpec getSpec() { return spec; }
}

// Implementations for Mandolin
class MandolinSpec implements InstrumentSpec {
    private BodyType bodyType;

    public MandolinSpec(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!(otherSpec instanceof MandolinSpec)) return false;
        MandolinSpec spec = (MandolinSpec) otherSpec;
        return bodyType == spec.bodyType;
    }
}

class Mandolin implements StringedInstrument {
    private String serialNumber;
    private double price;
    private MandolinSpec spec;

    public Mandolin(String serialNumber, double price, MandolinSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public double getPrice() { return price; }
    public String getSerialNumber() { return serialNumber; }
    public InstrumentSpec getSpec() { return spec; }
}
// You can repeat this pattern for Guitar, Mandolin, and other instruments...

// Inventory class
class Inventory {
    private List<StringedInstrument> instruments;

    public Inventory() {
        instruments = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        StringedInstrument newInstrument = null;
        if (spec instanceof DobroSpec) {
            newInstrument = new Dobro(serialNumber, price, (DobroSpec) spec);
        } else if (spec instanceof BanjoSpec) {
            newInstrument = new Banjo(serialNumber, price, (BanjoSpec) spec);
        } else if (spec instanceof BassSpec) {
            newInstrument = new Bass(serialNumber, price, (BassSpec) spec);
        } else if (spec instanceof FiddleSpec) {
            newInstrument = new Fiddle(serialNumber, price, (FiddleSpec) spec);
        } //... other conditions for other instruments

        if (newInstrument != null) {
            instruments.add(newInstrument);
        }
    }

    public List<StringedInstrument> search(InstrumentSpec searchSpec) {
        List<StringedInstrument> matchingInstruments = new ArrayList<>();
        for (StringedInstrument instrument : instruments) {
            if (instrument.getSpec().matches(searchSpec)) {
                matchingInstruments.add(instrument);
            }
        }
        return matchingInstruments;
    }
}

// Test Class
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        // ... [Same instrument additions] ...
        inventory.addInstrument("G12345", 999.95, new GuitarSpec(Type.ACOUSTIC));
        inventory.addInstrument("M12345", 799.95, new MandolinSpec(BodyType.A_STYLE));
        // Guitars
        inventory.addInstrument("A12345", 1499.95, new GuitarSpec(Type.ELECTRIC));
        inventory.addInstrument("A54321", 1599.95, new GuitarSpec(Type.ACOUSTIC));
        inventory.addInstrument("B12345", 1699.95, new GuitarSpec(Type.ELECTRIC));
        inventory.addInstrument("B54321", 1199.95, new GuitarSpec(Type.ACOUSTIC));

        // Fiddles
        inventory.addInstrument("C12345", 799.95, new FiddleSpec(Size.SIZE_44));
        inventory.addInstrument("C54321", 699.95, new FiddleSpec(Size.SIZE_12));
        inventory.addInstrument("D12345", 599.95, new FiddleSpec(Size.SIZE_34));
        inventory.addInstrument("D54321", 499.95, new FiddleSpec(Size.SIZE_14));

        // Banjos
        inventory.addInstrument("E12345", 1299.95, new BanjoSpec(Type.TENOR));
        inventory.addInstrument("E54321", 999.95, new BanjoSpec(Type.PLECTRUM));
        inventory.addInstrument("F12345", 899.95, new BanjoSpec(Type.BLUEGRASS));
        inventory.addInstrument("F54321", 799.95, new BanjoSpec(Type.TENOR));

        // Dobros
        inventory.addInstrument("G12345", 1399.95, new DobroSpec(Type.SQUARE_NECK));
        inventory.addInstrument("G54321", 1099.95, new DobroSpec(Type.ROUNDNECK));
        inventory.addInstrument("H12345", 999.95, new DobroSpec(Type.SQUARE_NECK));
        inventory.addInstrument("H54321", 1199.95, new DobroSpec(Type.ROUNDNECK));

        // Basses
        inventory.addInstrument("I12345", 799.95, new BassSpec(Type.ELECTRIC));
        inventory.addInstrument("I54321", 699.95, new BassSpec(Type.ACOUSTIC));
        inventory.addInstrument("J12345", 899.95, new BassSpec(Type.ELECTRIC));
        inventory.addInstrument("J54321", 999.95, new BassSpec(Type.ACOUSTIC));

        // A few more to reach 30
        inventory.addInstrument("K12345", 1299.95, new GuitarSpec(Type.ELECTRIC));
        inventory.addInstrument("L12345", 1399.95, new BanjoSpec(Type.BLUEGRASS));
        inventory.addInstrument("M12345", 1499.95, new DobroSpec(Type.ROUNDNECK));
        inventory.addInstrument("N12345", 1599.95, new BassSpec(Type.ELECTRIC));


        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an instrument type to search (Dobro, Banjo, Bass, Fiddle, Guitar, Mandolin): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        InstrumentSpec searchSpec = null;
        switch (choice) {
            case "dobro":
                System.out.println("Choose a type (e.g., SQUARE_NECK, ROUNDNECK): ");
                searchSpec = new DobroSpec(Type.valueOf(scanner.nextLine().trim().toUpperCase()));
                break;
            case "banjo":
                System.out.println("Choose a type (e.g., BLUEGRASS, TENOR): ");
                searchSpec = new BanjoSpec(Type.valueOf(scanner.nextLine().trim().toUpperCase()));
                break;
            case "bass":
                System.out.println("Choose a type (e.g., ELECTRIC_BASS): ");
                searchSpec = new BassSpec(Type.valueOf(scanner.nextLine().trim().toUpperCase()));
                break;
            case "fiddle":
                System.out.println("Choose a size (e.g., SIZE_44, SIZE_34): ");
                searchSpec = new FiddleSpec(Size.valueOf(scanner.nextLine().trim().toUpperCase()));
                break;
            case "guitar":
                System.out.println("Choose a type (e.g., ACOUSTIC, ELECTRIC): ");
                searchSpec = new GuitarSpec(Type.valueOf(scanner.nextLine().trim().toUpperCase()));
                break;
            case "mandolin":
                System.out.println("Choose a body type (e.g., A_STYLE, F_STYLE): ");
                searchSpec = new MandolinSpec(BodyType.valueOf(scanner.nextLine().trim().toUpperCase()));
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        List<StringedInstrument> matchingInstruments = inventory.search(searchSpec);
        if (!matchingInstruments.isEmpty()) {
            System.out.println("You might like these instruments:");
            for (StringedInstrument instrument : matchingInstruments) {
                System.out.println(instrument.getSerialNumber() + " priced at " + instrument.getPrice());
            }
        } else {
            System.out.println("Sorry, we have nothing for you.");
        }

        scanner.close();
    }
}