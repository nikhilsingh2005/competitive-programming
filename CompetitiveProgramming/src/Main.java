import java.io.*;
import java.util.*;
class Main {

    static boolean f(G x, TreeSet<Integer> s) {
        Integer y = s.higher(x.a);
        return y != null && y == x.b;
    }
    public static void main(String[] Z) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(r.readLine().trim());
        StringBuilder R = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(r.readLine().trim());
            if(n == 1) { r.readLine(); R.append("YES\n"); continue; }
            String[] s0 = r.readLine().trim().split(" ");
            int[] p = new int[n + 1];
            for (int i = 1; i <= n; i++) p[i] = Integer.parseInt(s0[i - 1]);
            int[] q = new int[n + 1];
            for (int i = 1; i <= n; i++) q[p[i]] = i;
            boolean ok = true;
            if(q[1] != 1 && q[1] != n) ok = false;
            else {
                if(q[1] == 1 && q[2] != n) ok = false;
                if(q[1] == n && q[2] != 1) ok = false;
            }
            if(!ok) { R.append("NO\n"); continue; }
            TreeSet<Integer> S = new TreeSet<>();
            S.add(q[1]); S.add(q[2]);
            TreeSet<G> Gs = new TreeSet<>();
            int A = Math.min(q[1], q[2]), B = Math.max(q[1], q[2]);
            if(B - A > 1) Gs.add(new G(A, B));
            for (int i = 3; i <= n; i++) {
                int x = q[i];
                if(S.contains(x)) { ok = false; break; }
                Integer C = S.lower(x), D = S.higher(x);
                if(C == null || D == null) { ok = false; break; }
                int d = (D - C) / 2, E = C + d, F = -1;
                if(((D - C) & 1) == 1) F = E + 1;
                if(x != E && (F == -1 || x != F)) { ok = false; break; }
                while(!Gs.isEmpty() && !f(Gs.first(), S)) Gs.pollFirst();
                int gm = Gs.isEmpty() ? -1 : Gs.first().c;
                if(gm != d) { ok = false; break; }
                G tmp = new G(C, D);
                if(!Gs.remove(tmp)) { ok = false; break; }
                S.add(x);
                if(x - C > 1) Gs.add(new G(C, x));
                if(D - x > 1) Gs.add(new G(x, D));
            }
            R.append(ok ? "YES\n" : "NO\n");
        }
        System.out.print(R);
    }
    static class G implements Comparable<G> {
        int a, b, c;
        public G(int a, int b) { this.a = a; this.b = b; this.c = (b - a) / 2; }
        public int compareTo(G o) {
            if(this.c != o.c) return o.c - this.c;
            if(this.a != o.a) return this.a - o.a;
            return this.b - o.b;
        }
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            G g = (G)o;
            return a == g.a && b == g.b;
        }
        public int hashCode() { return Objects.hash(a, b); }
    }
}