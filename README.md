# JavaMapStructTinkering

## Java 17 setup (macOS/Homebrew)

```bash
brew install openjdk@17
echo 'export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc
echo 'export CPPFLAGS="-I/opt/homebrew/opt/openjdk@17/include"' >> ~/.zshrc
source ~/.zshrc
java -version
```

## Development notes

- See `.cursor/rules/development.mdc` for in-repo guidance on common dev tasks. That directory is the primary place we store shared Cursor context, so keep it updated.

