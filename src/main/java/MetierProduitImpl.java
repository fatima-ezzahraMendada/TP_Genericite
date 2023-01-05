import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{
 private List<Produit> produits=new ArrayList<>();

 @Override
 public void add(Produit o) {
  Produit p1 = findById(o.getId());
  if(p1 == null) {
   this.produits.add(o);
  }else {
   System.out.println("error already exists!");
  }
 }

 @Override
 public List<Produit> getAll() {
  return this.produits;
 }

 @Override
 public Produit findById(long id) {
  for (Produit p: this.produits) {
   if(p.getId()==id){
    return p;
   }
  }
  return null;
 }

 @Override
 public void delete(long id) {
   for (Produit p : produits) {
    if (p.getId() == id) {
     produits.remove(p);
     return;
    }
   }
 }

 public List<Produit> getProduit() {
  return produits;
 }

 public void setProduit(List<Produit> produit) {
  this.produits = produit;
 }
}
