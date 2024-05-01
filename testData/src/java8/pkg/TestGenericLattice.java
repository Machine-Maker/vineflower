package pkg;

import java.util.Collection;
import java.util.List;

// Taken roughly from: https://en.wikipedia.org/wiki/Covariance_and_contravariance_(computer_science)
public class TestGenericLattice {
  static class Animal {}

  static class Cat extends Animal {}

  // these need to be fields to not get deleted by javac
  Collection<Cat> cc;
  List<? extends Cat> lec;
  List<? super Cat> lsc;
  Collection<? extends Cat> cec1;
  Collection<? extends Cat> cec2;
  Collection<? super Cat> csc1;
  Collection<? super Cat> csc2;
  List<? extends Animal> lea1;
  List<? extends Animal> lea2;
  List<? super Animal> lsa;
  List<? super Cat> lsc1;
  List<?> w1;
  List r1;

  public void testAssignable() {
    List<Animal> la = null;
    List<Cat> lc = null;
    cc = lc; // List <: Collection

    // Assign into wildcards
    lec = lc;
    lsc = lc;

    // into supertype
    cec1 = lec;
    cec2 = lc;
    csc1 = lsc;
    csc2 = lc;

    // Into supertype of parameter
    lea1 = lec;
    lea2 = la;

    lsa = la;

    // contravariance nightmare zone
    lsc1 = lsa;

    // rawtypes and wildcards
    w1 = lc;

    r1 = lc;
  }
}
