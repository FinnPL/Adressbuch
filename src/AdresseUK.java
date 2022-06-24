public class AdresseUK extends Adresse {

  @Override
  public void print() {
    System.out.println(getName() + " " + getNName() + " \n" + getHouse() + " \n" + getHnummer() + " " + getStrase()
        + " \n" + getOrt() + "\n " + getPlz() + " \n" + getLand());
  }

  public void setHouse(String houseNeu) {
    this.house = houseNeu;
  }

  public String getHouse() {
    return this.house;
  }

}
