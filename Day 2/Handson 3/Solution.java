import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
 static boolean flag=true;
 static boolean visited[]=new boolean[1000001];
 static int time[]=new int[1000001];
 static ArrayList<Integer> left=new ArrayList<Integer>();
 static ArrayList<Integer> right=new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
int n=in.nextInt();
int m=in.nextInt();
int a[]=in.nextIntArray(n);
int b[]=in.nextIntArray(m);
int ans=0;
for(int i=1;i<=100;i++)
{
    HashSet<Integer> set=new HashSet<Integer>();
    for(int j=1;j<=i;j++)
        if(j%i==0)
            set.add(j);
    boolean bool=true;
    for(int j=0;j<n;j++)
    {
        if(i%a[j]!=0)
            bool=false;
    }
    boolean bool1=true;
    for(int j=0;j<m;j++)
    {
        if(b[j]%i!=0)
            bool1=false;
    }
    if(bool&&bool1)
        ans++;
}
System.out.println(ans);
    }
    public static void DFS(int x,boolean visited[],ArrayList<Integer>[] adj)
    {
        visited[x]=true;
        for(int j=0;j<adj[x].size();j++)
        {
            if(!visited[adj[x].get(j)])
                DFS(adj[x].get(j),visited,adj);
        }
    }
    public static long pow(long n,long p,long m)
    {
         long  result = 1;
          if(p==0)
            return 1;
        if (p==1)
            return n;
        while(p!=0)
        {
            if(p%2==1)
                result *= n;
            if(result>=m)
            result%=m;
            p >>=1;
            n*=n;
            if(n>=m)
            n%=m;
        }
        return result;
    }
    public static int BinarySearch(int val,int a[])
    {
        int low=0;
        int high=a.length-1;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(a[mid]>val)
                high=mid;
            else
                low=mid+1;
        }
        return a[high];
    }


    static class Pair implements Comparable<Pair>{
        int r;
        int v;
        Pair(int mr,int er){
            r=mr;v=er;
        }
        @Override
        public int compareTo(Pair o) {
            if(o.r>this.r)
                return -1;
            else if(o.r<this.r)
                return 1;
            else
            {
                if(o.v>this.v)
                    return -1;
                else
                    return 1;
            }
            }
    }
    static class TVF implements Comparable<TVF>{
        int index,size;
        TVF(int i,int c){
            index=i;
            size=c;
        }
        @Override
        public int compareTo(TVF o) {
            if(o.size>this.size)
                return -1;
            else if(o.size<this.size)
                return 1;
            else return 0;
        }
    }
    public static long gcd(long a, long b) {
          if (b == 0) return a;
          return gcd(b, a%b);
        }
    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public   int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}