import random

def rand_website(items):
    return items[random.randint(0, len(items) - 1)]

websites = [
    "https://www.google.com",
    "https://www.wikipedia.org",
    "https://www.github.com",
    "https://www.stackoverflow.com",
    "https://www.reddit.com",
    "https://www.youtube.com",
    "https://www.amazon.com",
    "https://www.nytimes.com",
    "https://www.bbc.com",
    "https://www.microsoft.com"
]

print(rand_website(websites))