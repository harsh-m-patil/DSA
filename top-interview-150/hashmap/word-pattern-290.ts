function wordPattern(pattern: string, s: string): boolean {
  const chars = pattern.split("");
  const words = s.split(" ");

  if (chars.length !== words.length) {
    return false;
  }

  const map = new Map<string, string>();

  for (let i = 0; i < s.length; i++) {
    const char = chars[i];
    const word = words[i];

    if (map.has(char)) {
      if (map.get(char) !== word) {
        return false;
      }
    } else {
      if (Array.from(map.values()).includes(word)) {
        return false;
      }
    }

    map.set(char, word);
  }

  return true;
}
