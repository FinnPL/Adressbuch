public class AdresseDE extends Adresse {

  @Override
  public void print() {
    System.out.println(getName() + " " + getNName() + " \n" + getStrase() + " " + getHnummer() + " \n" + getPlz() + " "
        + getOrt() + " \n" + getLand());
  }

}
