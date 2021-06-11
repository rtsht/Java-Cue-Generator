# Java-Cue-Generator
Simple .cue file generator

## Why
I wanted to split a large (5 hr) audio file into tracks based off YouTube timestamps whilst adding tags such as title, track, and album as provided on the YouTube video page. This program only generates a .cue file which contains all the [info](https://en.wikipedia.org/wiki/Cue_sheet_(computing)) about where to split the file and what to call each of the tracks.

## What
Supply a .txt file with the songlist (example given in [songListSC.txt](songListSC.txt)), in the format "timestamp;performer;title;composer" and the program will output a .cue file with the matching metadata for each track.
