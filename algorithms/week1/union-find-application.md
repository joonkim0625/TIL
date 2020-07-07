# union-find applications

## a model for many physical systems:
    - N by N grid of sites
    - each site is open with probability p (or blocked with probability l - p)
    - system percolates iff top and bottom are connected by open sites

## when N is large, theory guarantees a sharp threshold p*
    - p > p*: almost certainly percolates
    - p < p*: almost certainly does not percolate

## Monte Carlo simulation
    - initialize N by N whole grid to be blocked
    - delcare random sites open until top connected to bottom
    - vacancy percentage estimates p*

## Q: how to check whether an N by N system percolates?
    - create an object for each site and name them 0 to N^2 - 1
    - sites are in same component if connected by open sites
    - percolates iff any site on bottom row is connected to site on top row

    - clever trick: introduce 2 virtual sites(and connections to top and bottom)
        - percolates iff virtual top is connected to virtual bottom site

## Q: how to model opening a new site?
    - A: connect newly opened site to all of its adjacent open sites

## Q: what is percolation threshold p*?
    - A: about 0.592746 for large square lattices
