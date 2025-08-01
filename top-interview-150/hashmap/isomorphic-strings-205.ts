function isIsomorphic(s: string, t: string): boolean {
  if (s.length !== t.length) return false;

  const charMap = new Map<string, string>();

  for (let i = 0; i < s.length; i++) {
    const sChar = s[i];
    const tChar = t[i];

    if (charMap.has(sChar)) {
      if (charMap.get(sChar) !== tChar) return false;
    } else {
      if (Array.from(charMap.values()).includes(tChar)) return false;
    }

    charMap.set(sChar, tChar);
  }

  return true;
}
