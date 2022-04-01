# git

[常用 Git 命令清单 - 阮一峰的网络日志 (ruanyifeng.com)](https://www.ruanyifeng.com/blog/2015/12/git-cheat-sheet.html)

c6aca34   v-d

554448f   v-c

91f8e4b   v-b

55d8949   v-a

![2541648548123_ pic](https://user-images.githubusercontent.com/43733497/160795960-1326742a-c83b-4ac5-be0f-319c40ff9509.jpg)


### 分支保护

1）将 master 设置为保护分支，并授权什么用户可以向 master 用户推送代码。

2）协作者

3）代码审查。不直接对master分支进行提交或合并，而是通过提交Pull Request，并且进行审阅和讨论后最终合并到 master。

# latest updation on this site: https://gitee.com/valerieJJ/GitExm

### 分支操作

``` bash
jj@master GitExm % git branch -v              
* development 44b1a00 add module2
  master      e942719 v-2
jj@master GitExm % git pull development       
fatal: 'development' does not appear to be a git repository
fatal: Could not read from remote repository.

Please make sure you have the correct access rights
and the repository exists.
jj@master GitExm % git pull origin development 
^C
jj@master GitExm % git pull gitee development
From https://gitee.com/valerieJJ/GitExm
 * branch            development -> FETCH_HEAD
Already up to date.
jj@master GitExm % git checkout master
error: Your local changes to the following files would be overwritten by checkout:
        .idea/workspace.xml
Please commit your changes or stash them before you switch branches.
Aborting
jj@master GitExm % git branch -v
* development 8ec3d27 add module2 2.2
  master      e942719 v-2
jj@master GitExm % git commit .idea/workspace.xml 
Aborting commit due to empty commit message.
jj@master GitExm % git branch -v                 
* development b1b7846 [ahead 1] add module2 2.2
  master      e942719 v-2
jj@master GitExm % git checkout master           
Switched to branch 'master'
Your branch is up to date with 'gitee/master'.
jj@master GitExm % git branch -v      
  development b1b7846 [ahead 1] add module2 2.2
* master      e942719 v-2
jj@master GitExm % git merge development
Updating e942719..b1b7846
Fast-forward
 .idea/compiler.xml                |   2 +
 .idea/misc.xml                    |   5 +++
 .idea/modules.xml                 |   1 +
 .idea/workspace.xml               | 122 ++++++++++++++++++++++++++++++++++++++++++++++++++++++------
 module2/module2.iml               |  11 ++++++
 module2/pom.xml                   |  15 ++++++++
 module2/src/main/java/Client.java |   6 +++
 pom.xml                           |   1 +
 8 files changed, 151 insertions(+), 12 deletions(-)
 create mode 100644 module2/module2.iml
 create mode 100644 module2/pom.xml
 create mode 100644 module2/src/main/java/Client.java
jj@master GitExm % git push gitee master
Counting objects: 4, done.
Delta compression using up to 12 threads.
Compressing objects: 100% (4/4), done.
Writing objects: 100% (4/4), 580 bytes | 580.00 KiB/s, done.
Total 4 (delta 3), reused 0 (delta 0)
remote: Powered by GITEE.COM [GNK-6.3]
To https://gitee.com/valerieJJ/GitExm.git
   e942719..b1b7846  master -> master
jj@master GitExm % git branch -v        
  development b1b7846 [ahead 1] add module2 2.2
* master      b1b7846 add module2 2.2
jj@master GitExm % git push origin master
Username for 'https://github.com': valerieJJ
Password for 'https://valerieJJ@github.com': 
remote: Support for password authentication was removed on August 13, 2021. Please use a personal access token instead.
remote: Please see https://github.blog/2020-12-15-token-authentication-requirements-for-git-operations/ for more information.
fatal: Authentication failed for 'https://github.com/valerieJJ/GitExm.git/'
jj@master GitExm % 
```

### feature 分支
``` bash
jj@master GitExm % git branch -v           
* development b1b7846 [ahead 1] add module2 2.2
  master      b1b7846 add module2 2.2]
  
jj@master GitExm % git switch -c feature-b1 
Switched to a new branch 'feature-b1'
jj@master GitExm % git branch -v           
  development b1b7846 [ahead 1] add module2 2.2
* feature-b1  b1b7846 add module2 2.2
  master      b1b7846 add module2 2.2

jj@master GitExm % git add module2/src/main/java/Feature.java

jj@master GitExm % git commit -m "feature" 
[feature-b1 b7daeda] feature
 1 file changed, 3 insertions(+)
 create mode 100644 module2/src/main/java/Feature.java
jj@master GitExm % git branch -v          
  development b1b7846 [behind 1] add module2 2.2
* feature-b1  b7daeda feature
  master      b1b7846 add module2 2.2

jj@master GitExm % git switch development
M       .idea/workspace.xml
Switched to branch 'development'
Your branch is behind 'origin/development' by 1 commit, and can be fast-forwarded.
  (use "git pull" to update your local branch)
jj@master GitExm % git branch -v          
* development b1b7846 [behind 1] add module2 2.2
  feature-b1  b7daeda feature
  master      b1b7846 add module2 2.2

jj@master GitExm % git merge --no-ff -m "merge feature-b1" feature-b1 
Merge made by the 'recursive' strategy.
 module2/src/main/java/Feature.java | 3 +++
 1 file changed, 3 insertions(+)
 create mode 100644 module2/src/main/java/Feature.java

jj@master GitExm % git branch -v                                        
* development 0d1f828 [ahead 2, behind 1] merge feature-b1
  feature-b1  b7daeda feature
  master      b1b7846 add module2 2.2
jj@master GitExm % git log --oneline                                    
0d1f828 (HEAD -> development) merge feature-b1
b7daeda (feature-b1) feature
b1b7846 (gitee/master, master) add module2 2.2
8ec3d27 (gitee/development) add module2 2.2
ae28c8f add module2 2.1
44b1a00 add module2
e942719 v-2
05e3c1a (origin/master) merged branch1
6274612 branch md-squashed
0ac78c3 v-maven
230e9d8 squashed v-cd
91f8e4b v-b
55d8949 v-a
df3d690 v-1
0beb42a initial

jj@master GitExm % git push gitee development

jj@master GitExm % git tag                   
v1.0
jj@master GitExm % git tag -a 'v2.0' -m 'tagged dev fea1' 0d1f828
jj@master GitExm % git tag                                       
v1.0
v2.0
jj@master GitExm % git push gitee tag v2.0  

```

- 创建分支 git branch [分支名]

- 查看分支 git branch -v

- 切换分支 git checkout [分支名]

- 合并分支 

  - 第一步：切换到接受修改的分支，git checkout master
  - 第二部：执行merge命令，git merge [分支名]

- 解决冲突
  ![2551648631100_ pic](https://user-images.githubusercontent.com/43733497/160796046-34600169-1065-4fa9-bd38-0310d1c58452.jpg)

### 合并多个commit

[「Git」合并多个 Commit - 简书 (jianshu.com)](https://www.jianshu.com/p/964de879904a)

- `pick` 的意思是要会执行这个 commit
- `squash` 的意思是这个 commit 会被合并到前一个commit

### 修改commit信息
https://cloud.tencent.com/developer/article/1730774

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
