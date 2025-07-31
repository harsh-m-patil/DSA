function findContentChildren(g: number[], s: number[]): number {
  let count = 0;
  s.sort((a, b) => a - b);
  g.sort((a, b) => a - b);

  for (const cookie of s) {
    if (cookie >= g[count]) count++;
  }

  return count;
}
