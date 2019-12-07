import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("большой", new String[]{"гигантский", "огромный",
                "громадный", "великий","крупный"});

        dictionary.put("человек", new String[]{"личность", "персона",
                "гомосапиенс", "индивидуум"});

        dictionary.put("красивый", new String[]{"прекрасный", "милый",
                "симпатичный", "спортивный",});

        dictionary.put("дом", new String[]{"хата", "жилище",
                "квартира", "особняк", "дворец", "вилла"});

        HashMap<String, String[]> bigDictionary = new HashMap<>(dictionary);

        Set<String> keys =dictionary.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next().toString();
            String [] values = dictionary.get(key);
            bigDictionary.put(key, values);
            for (int i = 0; i < values.length ; i++) {
                String newKeys = values[i];
                ArrayList<String> stringArrayList = new ArrayList<>(values.length);
                stringArrayList.addAll(Arrays.asList(values));
                stringArrayList.remove(newKeys);
                stringArrayList.add(key);
                String [] newValues = new String[stringArrayList.size()];
                newValues = stringArrayList.toArray(newValues);
                System.out.println(newKeys + " - " + Arrays.toString(values));
                bigDictionary.put(newKeys, newValues);
            }
        }

        System.out.println("Введите предложение из словаря, например большой дом: ");

        Scanner scanner = new Scanner(System.in);
        String sentences = scanner.nextLine().toLowerCase();
        String[] words = sentences.split(" ");
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = bigDictionary.get(words[i]);
            if (synonyms != null) {
                Random random = new Random();
                int randIndex = random.nextInt(synonyms.length);
                System.out.print(synonyms[randIndex] + " ");
            } else {
                System.out.print("Слово не найдено ");
            }
        }

    }
}
