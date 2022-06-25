public class AdresseUK extends Adresse {

  public AdresseUK(String Name, String NName, String Strase, int hnummer, String ort, String land, String plz,
      String house) {
    super(Name, NName, Strase, hnummer, ort, land, plz);
    this.house = house;
  }

  @Override
  public void print() {
    System.out.println(getName() + " " + getNName() + " \n" + getHouse() + " \n" + getHnummer() + " " + getStrase()
        + " \n" + getOrt() + "\n " + getPlz() + " \n" + getLand());
  }

  public String toFormatedString() {
    return (getName() + " " + getNName() + " \n" + getHouse() + " \n" + getHnummer() + " " + getStrase() + " \n"
        + getOrt() + "\n " + getPlz() + " \n" + getLand());
  }

  public void setHouse(String houseNeu) {
    this.house = houseNeu;
  }

  public String getHouse() {
    return this.house;
  }

}
