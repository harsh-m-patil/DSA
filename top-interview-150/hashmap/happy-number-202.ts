function isHappy(n: number): boolean {
  const set = new Set<number>();
  let num = n;

  while (!set.has(num)) {
    if (num === 1) return true;
    set.add(num);
    num = getDigitsSquaredSum(num);
  }

  return false;
}

function getDigitsSquaredSum(n: number): number {
  let num = n;
  let sum = 0;

  while (num > 0) {
    const digit = Math.floor(num % 10);
    sum += digit * digit;
    num /= 10;
  }

  return sum;
}
