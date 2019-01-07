# Contributing Guide
This project is built on top of [Dropwizard](http://dropwizard.io/). If you're unfamiliar with that I suggest you spend 30min to go through its excellent Getting Started tutorial. You will like what you see, I promise.

Of course you have to have an up-to-data JDK and Maven installed but if you've come this far I assume you already know that.

## Development environment setup
- `git clone https://github.com/marcelstoer/open-data-smn.git`
- `cd open-data-smn/`
- `mvn package`
- `java -jar target/open-data-smn-1.5.1-SNAPSHOT.jar server open-data-smn-dev.yml` <- adjust the version!
- [http://localhost:4711/swagger](http://localhost:4711/swagger)

## Commit messages

From: [http://git-scm.com/book/ch5-2.html](http://git-scm.com/book/ch5-2.html)
<pre>
Short (50 chars or less) summary of changes

More detailed explanatory text, if necessary.  Wrap it to about 72
characters or so.  In some contexts, the first line is treated as the
subject of an email and the rest of the text as the body.  The blank
line separating the summary from the body is critical (unless you omit
the body entirely); tools like rebase can get confused if you run the
two together.

Further paragraphs come after blank lines.

 - Bullet points are okay, too

 - Typically a hyphen or asterisk is used for the bullet, preceded by a
   single space, with blank lines in between, but conventions vary here
</pre>
