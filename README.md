# Page Replacement Simulation
## The Goal
+ Implement 3-page replacement algorithms FIFO, LRU, and OPT
+ Run experiments on the algorithms with different configurations
+ Talk about why the different configurations performed the way that they did
## Introduction
> Page replacement algorithms are essential components of operating systems that optimize memory management.
> These algorithms determine which pages in memory should be replaced when a new page needs to be loaded.
> Their primary goal is to minimize the number of page faults and maximize system performance.
> Popular page replacement algorithms include FIFO, LRU, and OPT, each employing different strategies to determine which pages to evict based on factors like recency of use or predicted future usefulness.
> These algorithms play a critical role in ensuring efficient memory utilization and improving the responsiveness of computer systems.

> a Fault is when the page does not exist and the frames list and must be added

> a Hit occurs when the page does exist in the frames list
## Algorithm Description
### FIFO
> This algorithm operates by added pages to the top of the queue
> and then removing pages from the bottom of the queue
### LRU
> This algorithm operates by adding pages to the top of the queue
> and then removing the pages from the bottom of the queue
> 
> What differentiates this algorithm form the FIFO is that when a hit occurs
> the page will be moved to the top of the queue, making it last longer before 
> gets removed
### OPT
>This algorithm or at least my implementation of it doesn't care so much about order.
> It operates by looking into the future and removing all pages that will no longer be required
> or one of the pages that are needed the least amount. When added to the frames list 
> it doesn't matter where the page is placed.
### The reference Strings & Configurations

### Best Performing Configurations

From all The Configurations These 4 all outperformed the others

RSS -> Reference String Size

NPF -> Number of Page Frames

> Reference String : [9, 5, 8, 2, 8, 8, 0, 7, 8, 2, 5, 5, 4, 0, 2, 3, 7, 7, 0, 4]
>
> Algorithm Type : FIFO, RSS : 20, NPF : 5
> Hits : 12
> Faults : 8
> Ratio : 1.5

> Reference String : [9, 5, 8, 2, 8, 8, 0, 7, 8, 2, 5, 5, 4, 0, 2, 3, 7, 7, 0, 4]
>
> Algorithm Type : OPT, RSS : 20, NPF : 5
> Hits : 12
> Faults : 8
> Ratio : 1.5

> Reference String : [9, 5, 8, 2, 8, 8, 0, 7, 8, 2, 5, 5, 4, 0, 2, 3, 7, 7, 0, 4]
>
> Algorithm Type : FIFO, RSS : 20, NPF : 7
> Hits : 12
> Faults : 8
> Ratio : 1.5

> Reference String : [9, 5, 8, 2, 8, 8, 0, 7, 8, 2, 5, 5, 4, 0, 2, 3, 7, 7, 0, 4]
>
> Algorithm Type : OPT, RSS : 20, NPF : 7
> Hits : 12
> Faults : 8
> Ratio : 1.5


### Why The Configurations the best performed did

It might be important to note that I decided to compare them based on their hit/fault ratio

I am not surprised to see that some of the best performing configuration had the algorithm type
of OPT, the reason for this being that this algorithm does the best it can to set itself up for success
it looks into the future and uses the occurrences of the pages to make it so that the pages int the list
are the ones the show up the most in the future.

I am a little surprised to see that some of the best performing configuration had the algorithm type
of FIFO because it removes things only based on what comes first.

I am not surprised that LRU was not one of the better performing algorithm because it uses information
form that past and that really doesn't make sense since what is important are the pages that we will need
 in the future.

I am also not surprised that of the ones that had the algorithm type of OPT the bigger the frame size the better
the ratio was.