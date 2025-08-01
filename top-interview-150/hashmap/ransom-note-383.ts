/**
 * @param {string} ransomNote - string we need to make from the characters from magazine atmost 1
 * @param {string} magazine - characters from this string can be used to construct the note
 * @returns {boolean} canConstruct the note or not
 * @description Implementation using a hashmap
 */
function canConstructMap(ransomNote: string, magazine: string): boolean {
  const charMap = new Map<string, number>();

  for (let char of magazine.split("")) {
    if (!charMap.has(char)) {
      charMap.set(char, 1);
    } else {
      charMap.set(char, charMap.get(char)! + 1);
    }
  }

  for (let char of ransomNote.split("")) {
    const val = charMap.get(char);
    if (!val) return false;
    charMap.set(char, charMap.get(char)! - 1);
  }

  return true;
}

/**
 * @param {string} ransomNote - string we need to make from the characters from magazine atmost 1
 * @param {string} magazine - characters from this string can be used to construct the note
 * @returns {boolean} canConstruct the note or not
 * @description Implementation using a frequency array
 */
function canConstruct(ransomNote: string, magazine: string): boolean {
  const charMap = new Array(26).fill(0);

  for (const char of magazine.split("")) {
    const idx = char.charCodeAt(0) - "a".charCodeAt(0);
    charMap[idx]++;
  }

  for (const char of ransomNote.split("")) {
    const idx = char.charCodeAt(0) - "a".charCodeAt(0);
    if (charMap[idx]-- <= 0) return false;
  }

  return true;
}
