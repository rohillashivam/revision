package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeat {

	public static void main(String[] args) {
		LongestSubStringWithoutRepeat lswr = new LongestSubStringWithoutRepeat();
		String str = "Wnb9z9dMc7E8v1RTUaZPoDNIAXRlzkqLaa97KMWLzbitaCkRpiE4J4hJWhRcGnC8H6"
				+ "mwasgDfZ76VKdXhvEYmYrZY4Cfmf4HoSlchYWFEb1xllGKyEEmZOLPh1V6RuM7Mxd7xK72aN"
				+ "rWS4MEaUmgEn7L4rW3o14Nq9l2EN4HH6uJWljI8a5irvuODHY7A7ku4PJY2anSWnfJJE1w8p12Ks3oZRx"
				+ "AF3atqGBlzVQ0gltOwYmeynttUmQ4QBDLDrS4zn4VRZLosOITo4JlIqPD6t4NjhHThOjJxpMp9fICk"
				+ "rgJeGiDAwsb8a3I7Txz5BBKV9bEfMsKNhCuY3W0ZHqY0MhBfz1CbYCzwZZdM4p65ppP9s5QJcfjadmMMi2"
				+ "6JKz0TVVwvNA8LP5Vi1QsxId4SI19jfcUH97wmZu0pbw1zFtyJ8GAp5yjjQTzFIboC1iRzklnOJzJld9TMa"
				+ "xqvBNBJKIyDjWrdfLOY8FGMOcPhfJ97Dph35zfxYyUf4DIqFi94lm9J0skYqGz9JT0kiAABQZDazZcNi80dS"
				+ "SdveSl6h3dJjHmlK8qHIlDsqFd5FMhlEirax8WA0v3NDPT8vPhwKpxcnVeu14Gcxr3h1wAXXV0y7Xy9qqB2NQ"
				+ "5HQLJ7cyXAckEYHsLCPSy28xcdNJatx1KLWohOQado4WywJbGvsFR17rKmvOPABweXnFD3odrbSMD4Na4nuBBs"
				+ "wvMmFRTUOcf7jZi4z5JnJqXz6hitaPnaEtjoSEBq82a52nvqYy7hhldBoxen2et2OMadVEHeTYLL7GLsIhTP6Ui"
				+ "zHIuzcJMljo4lFgW5AyrfUlIBPAlhwaSiJtTvcbVZynDSM6RO1PqFKWKg2MHIgNhjuzENg2oFCfW7z5KJvEL9qWq"
				+ "KzZNc0o3BMRjS04NCHFvhtsteQoQRgz84XZBHBJRdekCdcVVXu9c01gYRAz7oIAxN3zKZb64EFKssfQ4HW971jv3H"
				+ "7x5E9dAszA0HrKTONyZDGYtHWt4QLhNsIs8mo4AIN7ecFKewyvGECAnaJpDn1MTTS4yTgZnm6N6qnmfjVt6ZU51F9B"
				+ "xH0jVG0kovTGSjTUkmb1mRTLQE5mTlVHcEz3yBOh4WiFFJjKJdi1HBIBaDL4r45HzaBvmYJPlWIomkqKEmQ4rLAbY"
				+ "G7C5rFfpMu8rHvjU7hP0JVvteGtaGn7mqeKsn7CgrJX1tb8t0ldaS3iUy8SEKAo5IZHNKOfEaij3nI4oRVzeVOZsH"
				+ "91pMsA4jRYgEohubPW8ciXwVrFi1qEWjvB8gfalyP60n1fHyjsiLW0T5uY1JzQWHKCbLVh7QFoJFAEV0L516XmzI"
				+ "o556yRH1vhPnceOCjebqgsmO78AQ8Ir2d4pHFFHAGB9lESn3OtJye1Lcyq9D6X93UakA3JKVKEt6JZDLVBMp4msOe"
				+ "fkPKSw59Uix9d9kOQm8WCepJTangdNSOKaxblZDNJ5eHvEroYacBhd9UdafEitdF3nfStF7AhkSfQVC61YWWkKTN"
				+ "dx96OoJGTnxuqt4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6B"
				+ "G49XqyQoUwtriguO0yvWyaJqD4ye3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAO"
				+ "W8hln5nXnIWP6RBbfEkPPbxoToMbV";
		//str = "abcabcd";
		System.out.println(lswr.lengthOfLongestSubstring(str));
	}

	public int lengthOfLongestSubstring(String str) {
		if (str == null || str.isEmpty())
			return 0;

		if (str.length() == 1)
			return 1;

		//str = str.toLowerCase();

		//Map<Character, Integer> charMap = new HashMap<>();
		Set<Character> charMap = new HashSet<>();
		int start = 0, curr = start + 1;
		Integer maxLength = Integer.MIN_VALUE;
		//charMap.put(str.charAt(start), 0);
		charMap.add(str.charAt(start));
		while (curr < str.length()) {
			if (!charMap.contains(str.charAt(curr))) {
				charMap.add(str.charAt(curr));
				curr++;
				maxLength = Math.max(maxLength, charMap.size());
			} else {
				 //charMap.containsKey(str.charAt(curr))) {
				//int currLength = curr - start;
				//System.out.println("currLength :: "+currLength+" and curr :: "+curr+" and start :: "+start+" char :: "+str.charAt(curr));
				//maxLength = Math.max(maxLength, currLength);
				//maxLength = Math.max(maxLength, charMap.size());
				//curr++;
				charMap.remove(str.charAt(start));
				start++;
			}/* else {
				//maxLength = Math.max(maxLength, curr - start);
				maxLength = Math.max(maxLength, charMap.size());
				break;
			}  */
			//charMap.put(str.charAt(curr), curr);
			//charMap.add(str.charAt(curr));
		}

		return maxLength;
	}
}
