function isAnagram(s: string, t: string): boolean {
  if (s.length !== t.length) return false;
  const freqMap = new Array(26).fill(0);

  for (const char of s) {
    const idx = char.charCodeAt(0) - "a".charCodeAt(0);
    ++freqMap[idx];
  }

  for (const char of t) {
    const idx = char.charCodeAt(0) - "a".charCodeAt(0);
    if (freqMap[idx]-- <= 0) return false;
  }

  return true;
}

function isAnagramBetter(s: string, t: string): boolean {
  if (s.length !== t.length) return false;
  const freqMap = new Array(26).fill(0);

  for (let i = 0; i < s.length; i++) {
    freqMap[s.charCodeAt(i) - "a".charCodeAt(0)]++;
    freqMap[t.charCodeAt(i) - "a".charCodeAt(0)]--;
  }

  return freqMap.every((val) => val === 0);
}
