import java.util.*;

/**
 * Created by ruchitmehta on 7/27/17.
 */
public class LendingClubDeveloper {

    static class Developer{
        String name;
        List<String> languages;

        public Developer(String name, List<String> languages){
            this.name = name;
            this.languages = languages;
        }

        public List<String> getLanguages(){
            return languages;
        }

        public String getName(){
            return name;
        }

        @Override
        public String toString(){
            return this.name + " " + languages.toString();
        }
    }

    public static void main(String args[]){
        Developer d1 = new Developer("abc", Arrays.asList("java", "c++", "perl"));
        Developer d2 = new Developer("uid", Arrays.asList("java", "c", "golang"));
        Developer d3 = new Developer("xyz", Arrays.asList("php", "perl", "javascript"));
        Developer d4 = new Developer("rrr", Arrays.asList("shell", "react", "nodejs"));

        List<Developer> teams = new ArrayList<>();
        teams.add(d1);
        teams.add(d2);
        teams.add(d3);
        teams.add(d4);

        System.out.println(getUniqueLanguages(teams).size());
    }

    public static List<String> getUniqueLanguages(List<Developer> teams){
        HashSet<String> set = new HashSet<>();
        Developer d;
        List<String> uniqueLang = new ArrayList<String>();

        Iterator<Developer> iterator = teams.iterator();

        while(iterator.hasNext()){
            d = iterator.next();
            Iterator<String> it = d.getLanguages().iterator();
            while(it.hasNext()){
                String l = it.next();
                if(!set.contains(l)){
                    set.add(l);
                    uniqueLang.add(l);
                }
            }
        }

        return uniqueLang;
    }

}
