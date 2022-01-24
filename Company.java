public class Company {
    private String name;
    private double revenue;
    private double expenses;
    //constructor

    public Company(String name, double revenue, double expenses) {
        this.name = name;
        this.revenue = revenue;
        this.expenses = expenses;
    }

    public String getName() {
        return name;
    }
    public double profit()
    {
        return revenue-expenses;
    }

    @Override
    public String toString() {
        return name+" ("+profit()+")";
    }
}

