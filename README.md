# git

[常用 Git 命令清单 - 阮一峰的网络日志 (ruanyifeng.com)](https://www.ruanyifeng.com/blog/2015/12/git-cheat-sheet.html)

c6aca34   v-d

554448f   v-c

91f8e4b   v-b

55d8949   v-a

![image-20220330170405031](/Users/jj/Library/Application Support/typora-user-images/image-20220330170405031.png)

### 分支操作

- 创建分支 git branch [分支名]

- 查看分支 git branch -v

- 切换分支 git checkout [分支名]

- 合并分支 

  - 第一步：切换到接受修改的分支，git checkout master
  - 第二部：执行merge命令，git merge [分支名]

- 解决冲突

  ![image-20220330170510947](/Users/jj/Library/Application Support/typora-user-images/image-20220330170510947.png)

### 合并多个commit

[「Git」合并多个 Commit - 简书 (jianshu.com)](https://www.jianshu.com/p/964de879904a)

- `pick` 的意思是要会执行这个 commit
- `squash` 的意思是这个 commit 会被合并到前一个commit

### 暂时将未提交的变化移除，稍后再移入

[git-stash用法小结](https://www.cnblogs.com/tocy/p/git-stash-reference.html)

` $ git stash `, $ git stash save "some-message"

 `$ git stash pop` 将缓存堆栈中的第一个stash删除，并将对应修改应用到当前的工作目录下

`$ git stash apply  `将缓存堆栈中的stash多次应用到工作目录中，但并不删除stash拷贝。可以通过名字指定使用哪个stash

- 发现有一个类是多余的，想删掉它又担心以后需要查看它的代码，想保存它但又不想增加一个脏的提交。这时就可以考虑`git stash`。
- 使用`git stash`就可以将你当前未提交到本地（和服务器）的代码推入到Git的栈中，这时候你的工作区间和上一次提交的内容是完全一样的，所以你可以放心的修Bug，等到修完Bug，提交到服务器上后，再使用`git stash apply`将以前一半的工作应用回来。
- stash是本地的，不会通过`git push`命令上传到git server上。

### 抵消上一个提交

$git revert HEAD

```bash
$ git revert [倒数第一个提交] [倒数第二个提交]
```

### reset

$git reset 让最新提交的指针回到以前某个时点，该时点之后的提交都从历史中消失。

### checkout

$ git checkout -- [filename]撤销工作区文件的修改

$ git checkout [file] 恢复暂存区的指定文件到工作区

```bash
$git checkout  src/main/java/Main.java
```

$ git checkout [commit] [file]恢复某个commit的指定文件到暂存区和工作区
