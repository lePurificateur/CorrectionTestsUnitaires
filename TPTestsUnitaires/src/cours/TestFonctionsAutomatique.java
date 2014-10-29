package cours;

public class TestFonctionsAutomatique
{
    private boolean ok = true;

    private void teste(int attendu, int obtenu, String fonction)
    {
	if (attendu == obtenu)
	    System.out.println("test OK");
	else
	    {
		System.out.println("test " + fonction + " échoué : "
			       + obtenu + " != " + attendu);
		ok = false;
	    }
    }
    
    public boolean teste(Puissance p)
    {
	ok = true;
	teste(2, p.succ(1), "succ");
	teste(5, p.pred(6), "pred");
	teste(2, p.somme(2, 0), "somme");
	teste(9, p.somme(3, 6), "somme");
	teste(10, p.somme(13, -3), "somme");
	teste(2, p.produit(2, 1), "produit");
	teste(18, p.produit(3, 6), "produit");
	teste(-18, p.produit(-3, 6), "produit");
	teste(1, p.puissance(4, 0), "puissance");
	teste(5, p.puissance(5, 1), "puissance");
	teste(9, p.puissance(3, 2), "puissance");
	teste(1024, p.puissance(2, 10), "puissance");
	if(ok)
	    System.out.println("----> Soooo goood");
	else
	    System.out.println("----> Au moins un test a échoué.");
	return ok;
    }

    public static void main(String[] args)
    {
	Puissance p = new PuissanceAlex();
	TestFonctionsAutomatique t = new TestFonctionsAutomatique();
	t.teste(p);
    } 
}
