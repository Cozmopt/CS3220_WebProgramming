package HomeWorkOne.model;

public class Vaccine {
	
	static int idSeed;
	private int id;
	private String name;
	private int dosesRequired;
	private int daysBetweenDoses;
	private int dosesRecived;
	private int dosesUsed;
	
	public Vaccine() {
	}
	public Vaccine(String n, int drq, int dbd, int dr, int du){
		this.setId(idSeed++);
		this.name = n;
		this.dosesRequired = drq;
		this.daysBetweenDoses = dbd;
		this.dosesRecived = dr;
		this.dosesUsed = du;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDosesRequired() {
		return dosesRequired;
	}
	public void setDosesRequired(int dosesRequired) {
		this.dosesRequired = dosesRequired;
	}
	public int getDaysBetweenDoses() {
		return daysBetweenDoses;
	}
	public void setDaysBetweenDoses(int daysBetweenDoses) {
		this.daysBetweenDoses = daysBetweenDoses;
	}
	public int getDosesRecived() {
		return dosesRecived;
	}
	public void setDosesRecived(int dosesRecived) {
		this.dosesRecived = dosesRecived;
	}
	public int getDosesUsed() {
		return dosesUsed;
	}
	public void setDosesUsed(int dosesUsed) {
		this.dosesUsed = dosesUsed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
