function maxProfit(prices: number[]): number {
  if (prices.length <= 1) {
    console.error("Invalid length");
    return 0;
  }

  let profit = 0;
  let buyPrice = prices[0];

  for (const price of prices) {
    buyPrice = Math.min(buyPrice, price);
    profit = Math.max(profit, price - buyPrice);
  }

  return profit;
}
