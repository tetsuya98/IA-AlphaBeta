import java.util.*;
import java.lang.*;

public class ia_alphabeta {

	public static int nb_fils(int n) {
		int n_fils = 0;
		if (n >= 3)
			n_fils=n_fils+1;
		if (n >= 2)
			n_fils=n_fils+1;
		if (n >= 1)
			n_fils=n_fils+1;
			
		return n_fils;
	}

	public static int premier_fils(int n) {
		return n-nb_fils(n);
	}

	public static int frere(int f) {
		return f+1;
	}

	public static int eval(int n) {
		if (n % 2 == 0) {
			return 1;
		}
		return 0;
	}

	public static int max(int nb1, int nb2) {
		if (nb1 < nb2) {
			return nb2;
		}
		return nb1;
	}

	public static int min(int nb1, int nb2) {
		if (nb1 > nb2) {
			return nb2;
		}
		return nb1;
	}
		
	public static int alphabeta(int alpha, int beta, int n, int prof) {
		int m, nbr, f;
		System.out.println("valeur de n :" + n);
		
		if (n == 0) {
			return eval(prof);
		}else{
			if (prof % 2 == 0) {
				m = Integer.MIN_VALUE;
				nbr = nb_fils(n);
				f = premier_fils(n);
				while (m < beta && nbr != 0) {
					m = max(m, alphabeta(alpha, beta, f, prof+1));
					alpha = max(alpha, m);
					nbr=nbr-1;
					f = frere(f);
				}
			}else{
				m = Integer.MAX_VALUE;
				nbr = nb_fils(n);
				f = premier_fils(n);
				while (m > alpha && nbr != 0) {
					m = min(m, alphabeta(alpha, beta, f, prof+1));
					beta = min(beta, m);
					nbr=nbr-1;
					f = frere(f);
				}
			}
			return m;
		}
	}

	public static void main(String[] args) {
		if(alphabeta(Integer.MIN_VALUE, Integer.MAX_VALUE, 5, 0)==0)
			System.out.println("Le premier joueur est le vainqueur");
		else
			System.out.println("Le deuxieme joueur est le vainqueur");
		
	}
}
