import java.text.NumberFormat;
public class Main {
    public static void main(String[] args)
    {
        Company[] list = new Company[]{
        new Company("A",100000,90000),
        new Company("B",123123,45000),
        new Company("C",300000,190000),
        new Company("D",100000,99900),
        new Company("E",90909,33333),
        new Company("F",11122,3344),
        new Company("G",200800,105100),
        new Company("H",123321,100000),
        new Company("I",90000,45000),
        new Company("J",99999,11111)};
		
		
        double mean = calculateMean(list);
        System.out.println("The mean is "+ NumberFormat.getCurrencyInstance().format(mean));
        double sdv = calculateStDev(list,mean);
        System.out.println("The standard deviation is "+NumberFormat.getCurrencyInstance().format(sdv));
        System.out.println("\nWealthy companies: ");
        getWealthyCompanies(list,sdv,mean);
        System.out.println("\nPoorer companies: ");
        getPoorerCompanies(list,sdv,mean);
		
    }
	
    private static double calculateMean(Company[] list)
    {
        double sum =0;
        for (int i = 0; i <list.length ; i++) {
            sum+=list[i].profit();
        }
        return sum/list.length;
    }
    private static double calculateStDev(Company[] list, double mean)
    {
        double stdev =0;
        for (int i = 0; i <list.length ; i++) {
            stdev += (Math.pow((list[i].profit()-mean),2)/list.length);
        }
        stdev = Math.sqrt(stdev);
        return stdev;
    }
    private static void getWealthyCompanies(Company[] list, double sdv, double mean)
    {
        int count =0;
        for (int i = 0; i <list.length ; i++) {
            if(list[i].profit()>(mean+sdv))
            {
                System.out.println(list[i]);
                count++;
            }

        }
        System.out.println("There are "+count+" such companies");
    }
    private static void getPoorerCompanies(Company[] list, double sdv, double mean)
    {
        int count =0;
        for (int i = 0; i <list.length ; i++) {
            if(list[i].profit()<(mean-sdv))
            {
                System.out.println(list[i]);
                count++;
            }

        }
        System.out.println("There are " + count + " such companies");
    }
}