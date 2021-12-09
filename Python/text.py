#!/usr/bin/python3
"""Write a single python program to do the following operations on a text file by writing
different user defined functions.
a. Remove all the special characters.
b. Remove all single characters.
c. Substitute multiple spaces with single space.
d. Convert all the words into Lowercase.
e. Convert the words into literal form from their contracted form (e.g., Couldn’t -> Could
not)"""
# Our functions operate on strings rather than files.
import re
import sys
def compress_spaces(s): return re.sub(r'\s+', ' ', s)
def lower_case(s): return s.lower()


def remove_special(s): return ''.join(
    ch for ch in s if ch.isalnum() or ch.isspace())  # Remove all punctuation


CONTRACTIONS = (("can't", "cannot"), ("won't", "will not"), ("I'm", "I am"), ("shan't", "shall not"), ("he's", "he is "),
                ("she's", "she is"), ("it's", "it is "), ("'re", " are"), ("n't", " not"))


def uncontract(s):
    """Convert contracted forms ('can't') to their uncontracted forms ('cannot')"""
    for c, u in CONTRACTIONS:
        s = re.sub(c, u, s, flags=re.MULTILINE)
    return s


def remove_single(s: str) -> str:
    """Remove single letters, i.e. one-letter words (a non-space character surrounded by spaces)"""
    # This procedure becomes unnecesarily complex with regular expressions. We will due this manually.
    s2 = ''
    for (i, ch) in enumerate(s):
        if not ch.isspace() and not ((i == 0 and s[i+1].isspace()) or (i == (len(s)-1) and
                                                                   s[i-1].isspace()) or (s[i-1].isspace() and s[i+1].isspace())):
            s2 += ch
        elif ch.isspace():
            s2 += ch
    return s2


options = {'A': remove_special, 'B': remove_single,
           'C': compress_spaces, 'D': lower_case, 'E': uncontract}
source = dest = None
with open(input("Enter input file name: "), 'r') as fin:
    source = fin.read()
dest = input("Enter output file name: ")
print("Transformation options:")
print("A. Remove all special characters")
print("B. Remove all single characters")
print("C. Substitute multiple spaces with single space")
print("D. Convert all words into Lowercase")
print("E. Convert the words into literal form from their contracted form (e.g., Couldn’t -> Could not)")
choice = input("Enter choice: ").strip()[0].upper()
if choice not in options:
    print("Invalid Option!", file=sys.stderr)
    exit(1)
source = options[choice](source)
with open(dest, 'w') as dest:
    dest.write(source)
