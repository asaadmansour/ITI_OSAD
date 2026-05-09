# Git Lecture One - Notes

## What is Git?
git -> open source distributed version control system
- **version control** as it tracks my code and makes images and states (commits) for it and we can get back to it
- **distributed system** as it got multiple servers (everyone has a full copy of the repo)

---

## Repo Types
- **local repo** -> repo that exists on my machine
- **remote repo** -> repo online (GitHub, GitLab, etc.)

---

## Creating a Local Repo
to create a local repo for a project:
```bash
mkdir projectname
cd projectname
git init
```
this adds a hidden folder `.git` that has multiple files:

| Folder/File | Description |
|-------------|-------------|
| `config` | configs ex: name, email, tokens |
| `HEAD` | pointer to the current commit/branch |
| `info` | info for things that will be excluded |
| `refs` | references to branches and tags (stores commit hashes) |
| `objects` | past commits, trees, blobs (the actual data) |
| `hooks` | scripts that can be run before/after pushing, committing, etc. |
| `branches` | (deprecated) was used for branch shortcuts, now we use refs/heads |

> **Tip:** init with custom branch name:
> ```bash
> git init -b main  # init the repo and change its name from master to main
> ```

---

## The 3 Main States
```
Working Directory --> Staging Area --> Repository (commits)
    (untracked)        (tracked)         (committed)
```
1. **working** -> untracked work (modified files)
2. **staging** -> tracked, we did `git add` but we didn't commit yet
3. **committing** -> committing the changes with `git commit`

---

## Useful Commands

### Checking History
```bash
git log --graph --decorate    # to check history decorated with branches
git log -n1                   # last log/commit only
git log --oneline             # compact view one line per commit
```

### Restoring & Going Back
```bash
git restore <filename>        # discard changes in working directory
git checkout <commit-id>      # go back to specific commit (detached HEAD)
```
> ⚠️ **"check insertion and deletion"** before restoring, pushing, or merging!

### HEAD
- `HEAD` always points to the last commit of the current branch

---

## .gitignore
`.gitignore` -> the files listed in there won't be tracked, pushed, or anything
```
# example .gitignore
node_modules/
*.log
.env
```

---

## Reset vs Revert

### git reset
```bash
git reset --soft <commit-id>   # moves HEAD to prev commit, keeps staging & working dir as is
git reset --hard <commit-id>   # resets EVERYTHING (dangerous! loses changes)
```
> **Recovery tip:** even after `--hard` we can get back using `git reflog` to find the commit id and checkout to it!

### git revert
```bash
git revert <commit-id>         # creates a NEW commit that undoes the specified commit (safe!)
```
> **Difference:** reset rewrites history (moves HEAD back), revert creates new commit (history preserved)

---

## Removing Files
```bash
git rm filename    # remove file from both working dir and staging
git rm --cached filename  # remove from staging only (keep file locally)
```

---

## Branches
branches: it takes a copy from the codebase of the branch we are currently on and work on it for a feature and then merge without editing lines that are in both versions to avoid conflicts

### Branch Commands
```bash
git branch branchname          # create branch
git checkout branchname        # move to branch
git checkout -b branchname     # create AND move to branch (shortcut!)
git branch -d branchname       # delete branch (use -D to force delete)
git branch                     # list all branches
git branch -a                  # list all branches including remote
```

---

## Merging

merging can have 2 options:

### 1. Fast-Forward Merge
- happens when the main branch has **NO new commits** since we branched off
- git just moves the pointer forward, no merge commit created
- simple and clean history
```bash
git checkout main
git merge featurebranch        # fast-forward by default
```

### 2. Non-Fast-Forward (3-way merge)
- happens when **both branches have new commits**
- creates a new merge commit
- preserves branch history
```bash
git merge --no-ff featurebranch    # force merge commit even if fast-forward possible
```

> **Key Difference:**
> - **fast-forward** = linear history, no merge commit
> - **no-ff** = merge commit created, shows branch existed

---

## Rebase

instead of merging directly which will make a diamond shape and compact all the previous commits from the merged branch into one merge commit:
```
A - B - C - - - - - F (merge commit)
          \       /
            D - E
```
we can use rebase! it replays our commits on top of the target branch making a linear history:
```
A - B - C - D' - E'  (clean linear history!)
```

what does rebase do -> saves all the commit details (author, date, commit message) and replays them on top of the target branch

### Rebase Commands
```bash
git rebase branchname              # rebase current branch onto branchname
git rebase -i HEAD~3               # interactive rebase last 3 commits
```

### Interactive Rebase Options
| Option | What it does |
|--------|--------------|
| `pick` | keep the commit as is |
| `reword` | keep commit but edit the commit message |
| `edit` | pause to amend the commit |
| `squash` | merge commit into previous one (keeps both messages) |
| `fixup` | like squash but discards commit message |
| `drop` | remove the commit entirely |
| `reorder` | just change the order of pick lines |

> ⚠️ if we did `rebase -i` and we tried to push it will **reject**! why? because changing or deleting commits needs more permission as it's on the remote repo. here comes:

### Force Push
```bash
git push --force                   # force push (overwrites remote history!)
git push --force-with-lease        # safer: fails if someone else pushed (recommended)
```
used in scenarios like:
- change commit history on the remote repo
- after reset
- after rebase -i

---

## Cherry-Pick
cherry-pick -> helps us pick a specific commit from another branch and add it into our current branch

```bash
git cherry-pick <commit-id>        # apply specific commit to current branch
git cherry-pick <id1> <id2>        # cherry-pick multiple commits
```

---

## Stash
stash -> like a stack (LIFO) for temporarily saving changes without committing. useful when we need to switch to another branch but don't want to commit half-done work

### Stash Commands
```bash
git stash                          # save current changes to stash
git stash push -m "message"        # stash with a description
git stash list                     # see all stashes we have
git stash pop                      # get latest work from stash and remove it from stack
git stash apply                    # apply stash but keep it in the stack
git stash drop                     # remove a stash after resolving conflict
git stash clear                    # remove all stashes
```

> if popping causes conflict -> solve the conflict manually, then `git stash drop`

---

## Other Useful Commands

```bash
git clean -fd                      # remove untracked files and directories (dangerous!)
git clean -n                       # dry run: shows what would be deleted
git show <commit-id>               # show details of a specific commit (diff, author, message)
git show HEAD                      # show the last commit
git grep "word"                    # search for a certain word in the repo files
git grep -n "word"                 # search with line numbers
```

### Aliases
```bash
git config --global alias.co checkout    # now 'git co' = 'git checkout'
git config --global alias.br branch
git config --global alias.st status
git config --global alias.lg "log --oneline --graph"
```

### Archive
```bash
git archive --format=zip HEAD -o release.zip   # create zip of current state
git archive --format=tar HEAD -o release.tar   # create tar archive
```

---

## Fork vs Clone
- **fork** -> get a copy on **your remote repo** from someone else's project (used for contributing to others' repos)
- **clone** -> get a copy on **your local machine** from a remote repo

---

## Tags & Releases
in production we use **releases** not branches, and the tag is usually the version number (v1.0.0, v2.1.0, etc.)

```bash
git tag                            # list all tags
git tag v1.0.0                     # create lightweight tag
git tag -a v1.0.0 -m "Release 1"   # create annotated tag with message
git push origin v1.0.0             # push specific tag to remote
git push origin --tags             # push all tags
```

---

## Plumbing vs Porcelain Commands
there are two types of git commands:

| Type | Description | Examples |
|------|-------------|----------|
| **Porcelain** | high-level user-friendly commands we use daily | `git add`, `git commit`, `git push`, `git log` |
| **Plumbing** | low-level commands that porcelain uses internally | `git hash-object`, `git cat-file`, `git update-index` |

> porcelain = the pretty surface (like toilet porcelain lol), plumbing = the pipes underneath

---

## Git Internals (How Git Stores Data)
git stores everything as **objects** with SHA-1 hashes:

| Object Type | What it stores |
|-------------|----------------|
| **blob** | file content (no filename, just content) |
| **tree** | directory structure (filenames + pointers to blobs/trees) |
| **commit** | snapshot (pointer to tree + author + message + parent commit) |
| **tag** | annotated tag info |

structure: files content get hashed and converted to objects -> objects are inside trees -> commits point to trees

```
commit --> tree --> blob (file1.txt)
             |
             +--> blob (file2.txt)
             |
             +--> tree (subfolder) --> blob (file3.txt)
```

---

## Git Hooks
hooks are scripts that run automatically before/after certain git events. located in `.git/hooks/`

| Hook | When it runs |
|------|--------------|
| `pre-commit` | before commit (useful for linting, formatting) |
| `post-commit` | after commit |
| `pre-push` | before push |
| `pre-merge-commit` | before merge commit is created |
| `post-merge` | after merge is done |
| `commit-msg` | validate commit message format |

> example: pre-commit hook for linting -> runs `eslint` or `prettier` before allowing commit

---

## Quick Reference Cheat Sheet

| Command | What it does |
|---------|--------------|
| `git init` | create new repo |
| `git clone url` | clone remote repo |
| `git add .` | stage all files |
| `git commit -m "msg"` | commit with message |
| `git status` | check current state |
| `git log` | view commit history |
| `git branch` | list branches |
| `git checkout -b name` | create & switch branch |
| `git merge branch` | merge branch into current |
| `git rebase branch` | rebase onto branch |
| `git pull` | fetch + merge from remote |
| `git push` | push to remote |
| `git stash` | save work temporarily |
| `git cherry-pick id` | apply specific commit |
| `git reflog` | see all HEAD movements (recovery!) |