#include<set>
#include<cmath>
#include<ctime>
#include<cstdio>
#include<cstdlib>
#include<vector>
#include<windows.h>
#include<algorithm>
#include<iostream>
#include<conio.h>
#include<fstream>
using namespace std;

#define fblack 0
#define fblue 1
#define fgreen 2
#define fcyan 3
#define fred 4
#define fpurple 5
#define fyellow 6
#define fwhite 7
#define fgray 8
#define flight 8
#define bblack 0
#define bblue 16
#define bgreen 32
#define bcyan 48
#define bfred 64
#define bpurple 80
#define byellow 96
#define bwhite 112
#define bgray 128
#define blight 128
#define dirkey -32
#define upkey 72
#define downkey 80
#define leftkey 75
#define rightkey 77
#define wclear system("cls")
#define KEY_DOWN(VK_NONAME) ((GetAsyncKeyState(VK_NONAME) & 0x8000) ? 1:0)
#define LL long long

void flash(int times){
    while(times--){
        system("color 08");
        Sleep(300);
        system("color 80");
        Sleep(300);
    }
    //Sleep(1000);
    system("color 08");
}
void HindCursor(){
    HANDLE handle=GetStdHandle(STD_OUTPUT_HANDLE);
    CONSOLE_CURSOR_INFO CursorInfo;
    GetConsoleCursorInfo(handle,&CursorInfo);
    CursorInfo.bVisible=false;
    SetConsoleCursorInfo(handle,&CursorInfo);
}
struct Button{
    int x,y,color;
    const char *name;
    int len;
};
void GetPos(POINT &pt){
    HWND hwnd=GetForegroundWindow();
    GetCursorPos(&pt);
    ScreenToClient(hwnd,&pt);
    pt.y=pt.y/16,pt.x=pt.x/8;
    swap(pt.x,pt.y);
}
void color(int a){
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),a);
}
void gto(int x,int y){
    COORD pos;pos.X=y;pos.Y=x;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE),pos);
}
Button NewButton(int x,int y,int color,const char *name){
    Button t;
    t.x=x,t.y=y,t.name=name;
    t.color=color;
    t.len=strlen(name);
    return t;
}
bool Preserve(Button A){
    gto(A.x,A.y),color(A.color),printf("%s",A.name);
    POINT pt;
    GetPos(pt);
    if(pt.x==A.x&&(pt.y>=A.y&&pt.y<=A.y+A.len)){
        color(112),gto(A.x,A.y),printf("%s",A.name);
        if(KEY_DOWN(MOUSE_MOVED)) return 1;
    }
    return 0;
}
pair<int,int> GetXY(){
    HANDLE hStdout;
    CONSOLE_SCREEN_BUFFER_INFO pBuffer;
    hStdout = GetStdHandle(STD_OUTPUT_HANDLE);
    GetConsoleScreenBufferInfo(hStdout, &pBuffer);
    return make_pair(pBuffer.dwCursorPosition.Y,pBuffer.dwCursorPosition.X);
}
template <typename T>void Tprint(int Nx,int Ny,int Color,T a){
    int x=GetXY().first,y=GetXY().second;
    gto(Nx,Ny),color(Color),cout<<a;
    gto(x,y);
}
void ColorPrint(){
    for(int i=0;i<256;i++)
        color(i),printf("%d\n",i);
}
void SetWindow(const char *name,int c,int w){
    char str[30];
    sprintf(str,"title %s",name);
    system(str);
    sprintf(str,"mode con cols=%d lines=%d",w,c);
    system(str);
}
void SetWindow(const char *name,int c,int w,int x,int y){
    SetConsoleTitle(name);
    HWND hwnd;
    hwnd=GetForegroundWindow();
    SetWindowPos(hwnd,HWND_TOP,y,x,w*8,c*16,SWP_SHOWWINDOW);
}
int read(){
    color(fwhite+flight);
    int x=0,f=1;char c=getchar();
    while(c<'0'||c>'9'){if(c=='-')f=-1;c=getchar();}
    while(c>='0'&&c<='9'){x=x*10+c-'0';c=getchar();}
    return x*f;
}

#define TP Tprint
#define WINDOWC 45
#define WINDOWW 55
#define INF 0x3f3f3f3f
#define OC fwhite+flight+bblack //original color

bool InRange(int x){
    return x>=0&&x<=WINDOWC;
}

int BossFlag;
int OwnShotTimes,OwnLoseBlood,OwnShotOnTimes;
int MoneyFlash,ScoreFlash;

const int ConstNewDy[4]={-1,0,1};
#define MAX_BULLET_TYPE_NUM 3
const int ConstBulletColor[MAX_BULLET_TYPE_NUM+5]={0,fyellow,fred+flight,fred+flight,fblue+flight,fred+bwhite};
const char ConstBulletShape[MAX_BULLET_TYPE_NUM+5]={0,'*','*','O','|','%'};
const int ConstBulletDamage[MAX_BULLET_TYPE_NUM+5]={0,50,80,500,20,300};
/*Move 1 block every 100-Speed ms*/
const int ConstBulletSpeed[MAX_BULLET_TYPE_NUM+5]={0,50,30,10,80,20};
/*The color of the full block in the blood line*/
const int ConstBloodColor[4]={0,fred,fyellow,fgreen};

#define MAX_BOSS_NUM 10
const int ConstBossFullBlood[MAX_BOSS_NUM+5]={0,1000,3000,5000,10000,30000,50000,100000,300000,500000,1000000};
const int ConstBossShotSpeed[MAX_BOSS_NUM+5][2]={{0,0},{30,-3900},{30,-3400},{50,-2900},{50,-2400},{70,-1900},{70,-1400},{90,-900},{90,-400},{100,-400},{100,-400}};
const int ConstBossStopCD[MAX_BOSS_NUM+5]={0,3200,3400,3600,3800,4000,4200,4400,4600,4800,5000};
const int ConstBossStopTime[MAX_BOSS_NUM+5]={0,3000,2800,2600,2400,2200,2000,1800,1600,1400,1200};
const int ConstBossMoveSpeed[MAX_BOSS_NUM+5]={0,800,800,800,850,850,850,900,900,900,950};
const int ConstBossScore[MAX_BOSS_NUM+5]={0,10000,20000,40000,80000,160000,320000,640000,1280000,2560000,5120000};
const int ConstBossMoney[MAX_BOSS_NUM+5]={0,100,200,500,1000,2000,5000,8000,10000,20000,50000};
const int ConstBossNeedScore[MAX_BOSS_NUM+5]={0,500,1000,1500,2000,2500,3000,3500,4000,4500,5000};

struct Bullet{
    int isExist;
    int x,y,Type;
    int dx,dy,LastBulletRefreshTime;
    Bullet(){LastBulletRefreshTime=-INF;}
    Bullet(int isExist_,int x_,int y_,int Type_,int dx_,int dy_):
        isExist(isExist_),x(x_),y(y_),Type(Type_),dx(dx_),dy(dy_){}
};

void MoveBullet(Bullet&);
/*We must use Bullet*, or we can't change the data(position of the bullet) in the set*/
set<Bullet*> Ammo;
void BulletsRefresh(){
    vector<set<Bullet*>::iterator> Throw;
    for(set<Bullet*>::iterator it=Ammo.begin();it!=Ammo.end();it++){
        Bullet *New=*it;
        MoveBullet(*New);
        /*We can't erase it right away*/
        if(!New->isExist)
            Throw.push_back(it);
    }
    for(int i=0;i<int(Throw.size());i++)
        Ammo.erase(Throw[i]);
}

int BEGINTIME;

int UFOAddBlood,UFOAddShotSpeed,UFOAddMoveSpeed,Added;

struct UFO{
    /*
    Shape of the UFO:
    0000/0000
       @@@
      (OOO)
       \-/
        V
    */
    int isExist;
    int x,y;//position of the head
    int dx,dy;
    int Blood,FullBlood;
    int ShotSpeed,LastShotTime;
    int MoveSpeed;
    int LastMoveTime;
    int Score,Money;

    UFO(){
        if(BossFlag&&!Added)
            UFOAddBlood+=100,UFOAddShotSpeed+=100,UFOAddMoveSpeed+=100,Added=1;
        if(!BossFlag&&Added)
            UFOAddBlood-=100,UFOAddShotSpeed-=100,UFOAddMoveSpeed-=100,Added=0;
        isExist=1;
        x=0,y=rand()%(WINDOWW-4)+4;//Must be in the screen
        FullBlood=rand()%300+100+UFOAddBlood;
        Blood=FullBlood;
        ShotSpeed=rand()%1000+UFOAddShotSpeed;
        /*Move 1 block every 1000-MoveSpeed ms*/
        MoveSpeed=rand()%600+300+UFOAddMoveSpeed;
        LastMoveTime=LastShotTime=-INF;
        dx=1,dy=0;
        Score=FullBlood/30+((clock()-BEGINTIME)/10000);
        Money=MoveSpeed/100.0+FullBlood/100.0;
    }
    /*effects when being hit*/
    void Flash(){
        /*the head is sure to be in the screen so we needn't check*/
        if(!isExist)
            return;
        if(x>0&&x<WINDOWC)
            TP(x,y,fpurple+bwhite,'V');
        if(x-1>0&&x-1<WINDOWC)
            TP(x-1,y-1,fpurple+bwhite,"\\-/");
        //Sleep(100);
        if(x>0&&x<WINDOWC)
            TP(x,y,fpurple+bblack,'V');
        if(x-1>0&&x-1<WINDOWC)
            TP(x-1,y-1,fpurple+bblack,"\\-/");
    }
    /*Check if hit only on the body*/
    bool Hit(int tx,int ty){
        return (tx==x&&ty==y)||
               (tx==x-1&&ty>=y-1&&ty<=y+1);
    }
    /*To check if it will hit another UFO*/
    void BloodRefresh(int NewX,int NewY){
        /*To appear gradually, we should check the position*/
        if(x-2>=0){
            TP(x-2,y-1,OC,"   ");
            if(isExist)
                if(NewX-2<WINDOWC){
                    /*Round up*/
                    int FullBlock=(Blood*3+FullBlood-1)/FullBlood;   //Number of "@"
                    int EmptyBlock=3-FullBlock;                      //Number of "O"
                    int BloodColor=ConstBloodColor[FullBlock];
                    /*Print the blood line*/
                    for(int i=1;i<=FullBlock;i++)
                        TP(NewX-2,NewY-2+i,BloodColor+bblack,'@');
                    for(int i=1;i<=EmptyBlock;i++)
                        TP(NewX-2,NewY-2+FullBlock+i,fgray+bblack,'O');
                }
        }
        /*Print the blood/fullblood number*/
        /*Due to %06d we can't use TP*/
        if(x-3>=0){
            TP(x-3,y-4,OC,"         ");
            if(isExist){
                if(NewX-3<WINDOWC){
                    gto(NewX-3,NewY-4),color(fcyan+bblack),printf("%04d",Blood);
                    TP(NewX-3,NewY,fcyan+bblack,'/');
                    gto(NewX-3,NewY+1),color(fcyan+bblack),printf("%04d",FullBlood);
                }
            }
        }
        if(x-3>=WINDOWC)
            isExist=0;
    }
    /*Clear the shape after it died*/
    void ClearPrint(){
        BloodRefresh(x,y);
        if(x-1>=0&&x-1<WINDOWC)
            TP(x-1,y-1,OC,"   ");
        if(x>=0&&x<WINDOWC)
            TP(x,y,OC,' ');
    }
    void Shot(){
        int t=clock();
        if(!ShotSpeed||LastShotTime>=t-(5000-ShotSpeed))
            return;
        LastShotTime=t;
        if(x>0){
            Bullet *tmp=new Bullet(1,x+1,y,2,1,0);
            Ammo.insert(tmp);
        }
    }
};
/*It is similar to set<Bullet*> in struct Plane*/
set<UFO*> Enemy;

bool UFOCrash(int,int);
bool UFOCrash(UFO,int,int,set<UFO*>::iterator);

/*Move the plane to a new place*/
void UFOMovePrint(UFO &me,set<UFO*>::iterator id){
    int t=clock();
    if(me.LastMoveTime>=t-(1000-me.MoveSpeed))
        return;
    me.LastMoveTime=t;
    /*Change the direction*/
    if(rand()%3==0)
        me.dy=ConstNewDy[rand()%3];
    int NewX=me.x+me.dx,NewY=me.y+me.dy;
    if(UFOCrash(me,NewX,NewY,id)||NewY-4<0||NewY+4>=WINDOWW)//||NewX<0||NewY-4<0||NewX>=WINDOWC||NewY+4>=WINDOWW){
        for(int i=0;i<3;i++){
            me.dy=ConstNewDy[rand()%3];
            NewX=me.x+me.dx,NewY=me.y+me.dy;
            if(!(UFOCrash(me,NewX,NewY,id)||NewY-4<0||NewY+4>=WINDOWW))//||NewX<0||NewY-4<0||NewX>=WINDOWC||NewY+4>=WINDOWW))
                break;
        }

    if(UFOCrash(me,NewX,NewY,id)||NewY-4<0||NewY+4>=WINDOWW)//||NewX<0||NewY-4<0||NewX>=WINDOWC||NewY+4>=WINDOWW)
        return;
    //TP(me.x,me.y,OC,' ');
    if(NewX<WINDOWC){
        TP(me.x,me.y,fwhite+flight+bblack,' ');
        if(me.isExist) TP(NewX,NewY,fwhite+flight+bblack,'V');
    }
    if(NewX-1>=0&&NewX-1<WINDOWC){
        TP(me.x-1,me.y-1,fwhite+flight+bblack,"   ");
        if(me.isExist) TP(NewX-1,NewY-1,fwhite+flight+bblack,"\\-/");
    }
    me.BloodRefresh(NewX,NewY);
    me.x=NewX,me.y=NewY;
}
int UFORefreshTime=3000,LastUFORefreshTime=0;
void UFORefresh(){
    int t=clock();
    if(LastUFORefreshTime<t-UFORefreshTime){
        UFO *tmp=new UFO;
        Enemy.insert(tmp);
        LastUFORefreshTime=t;
    }
    vector<set<UFO*>::iterator> Throw;
    for(set<UFO*>::iterator it=Enemy.begin();it!=Enemy.end();it++){
        UFO *New=*it;
        if(!New->isExist)
            Throw.push_back(it);
        UFOMovePrint(*New,it);
        New->Shot();
    }
    for(int i=0;i<int(Throw.size());i++)
        Enemy.erase(Throw[i]);
}

#define MAX_BUFF_NUM 5
const int ConstBuffAppearPossibility[2][1000]={
    {1,2,2,2,2,2,2,3,4,5},
    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,5}
};
const int ConstBuffAppearTime[MAX_BUFF_NUM+5]={0,5000,5000,5000,5000,5000};
const int ConstBuffLastTime[MAX_BUFF_NUM+5]={0,5000,0,5000,10000,5000};
const char ConstBuffName[MAX_BUFF_NUM+5]={0,'B','C','P','D','S'};
const char ConstBuffColor[MAX_BUFF_NUM+5]={0,fblue+flight,fgreen+flight,fred+flight,fyellow+flight,fpurple+flight};

struct Plane{
    /*
    Shape of the plane:
           ^             (x,y)
          / \            (x+1,y-1) to (x+1,y+1)
      |---------|        (x+2,y-5) to (x+2,y+5)
           |             (x+3,y)
          ---            (x+4,y-1) to (x+4,y+1)
       @@@@@@@@@         (x+5,y-4) to (x+5,y+4)
      (OOOOOOOOO)
     000000/000000       (x+6,y-6) to (x+6,y+6)  (Blood and full blood)
    */
    int x,y;//position of the head
    int Blood,FullBlood;
    int LastShotTime;
    int ShotSpeed;
    LL Score,BossScore;
    int Buffs[10],GetBuffTime[10];
    double AddAtack,AddShotSpeed;
    int Money;
    int MeetBossTimes;
    void Init(bool isDebug){
        if(isDebug){
            Ammo.clear();
            LastShotTime=-INF;
            /*It shot one time in at most 1000-ShotSpeed ms*/
            ShotSpeed=20;
            Blood=10000,FullBlood=10000;
            x=WINDOWC/2,y=WINDOWW-8;
            Score=BossScore=0;
            AddAtack=AddShotSpeed=50.0;
            MeetBossTimes=1;
            memset(Buffs,0,sizeof Buffs);
        }
        else{
            Ammo.clear();
            LastShotTime=-INF;
            /*It shot one time in at most 1000-ShotSpeed ms*/
            ShotSpeed=500;
            Blood=500,FullBlood=500;
            x=WINDOWC/2,y=WINDOWW-8;
            Score=BossScore=0;
            AddAtack=AddShotSpeed=1.0;
            MeetBossTimes=1;
            memset(Buffs,0,sizeof Buffs);
        }
    }
    bool NeedBoss(){
        if(Score>=ConstBossNeedScore[MeetBossTimes])
            return MeetBossTimes++,1;
        return 0;
    }
    void Flash(int fcolor){
        TP(x,y,fcolor+bwhite,'^');
        TP(x+1,y-1,fcolor+bwhite,'/'),TP(x+1,y+1,fcolor+bwhite,'\\');
        TP(x+2,y-5,fcolor+bwhite,'|');for(int i=y-4;i<=y+4;i++)TP(x+2,i,fcolor+bwhite,'-');TP(x+2,y+5,fcolor+bwhite,'|');
        TP(x+3,y,fcolor+bwhite,'|');
        TP(x+4,y-1,fcolor+bwhite,'-'),TP(x+4,y,fcolor+bwhite,'-'),TP(x+4,y+1,fcolor+bwhite,'-');
        Sleep(200);
        TP(x,y,OC,'^');
        TP(x+1,y-1,OC,'/'),TP(x+1,y+1,OC,'\\');
        TP(x+2,y-5,OC,'|');for(int i=y-4;i<=y+4;i++)TP(x+2,i,OC,'-');TP(x+2,y+5,OC,'|');
        TP(x+3,y,OC,'|');
        TP(x+4,y-1,OC,'-'),TP(x+4,y,OC,'-'),TP(x+4,y+1,OC,'-');
    }
    /*Check if hit only on the body*/
    bool Hit(int tx,int ty){
        return (tx==x&&ty==y)||
               (tx==x+1&&ty>=y-1&&ty<=y+1)||
               (tx==x+2&&ty>=y-5&&ty<=y+5)||
               (tx==x+3&&ty==y)||
               (tx==x+4&&ty>=y-1&&ty<=y+1);
    }
    /*Move the blood line(just move)*/
    /*Remember to check if the position is OK before using*/
    /*And it won't update the plane's position (x and y)*/
    void BloodRefresh(int NewX,int NewY){
        TP(x+5,y-4,OC,"         ");
        TP(x+6,y-6,OC,"             ");
        /*Round up*/
        int FullBlock=(Blood*9+FullBlood-1)/FullBlood;   //Number of "@"
        int EmptyBlock=9-FullBlock;                      //Number of "O"
        int BloodColor=ConstBloodColor[(FullBlock+2)/3];
        /*Print the blood line*/
        for(int i=1;i<=FullBlock;i++)
            TP(NewX+5,NewY-5+i,BloodColor+bblack,'@');
        for(int i=1;i<=EmptyBlock;i++)
            TP(NewX+5,NewY-5+FullBlock+i,fgray+bblack,'O');
        /*Print the blood/fullblood number*/
        /*Due to %06d we can't use TP*/
        gto(NewX+6,NewY-6),color(fgray+bblack),printf("%06d",Blood);
        TP(NewX+6,NewY,OC,'/');
        gto(NewX+6,NewY+1),color(fgray+bblack),printf("%06d",FullBlood);
    }
    /*Move the plane to a new place*/
    void MovePrint(int NewX,int NewY,int flag=1){
        /*Insure that player can control the plane when the mouse is out of screen*/
        NewX=min(NewX,WINDOWC-7);
        NewY=min(max(NewY,6),WINDOWW-7);
        if(flag&&NewX==x&&NewY==y)
            return;
        //gto(WINDOWC-1,0),color(OC),printf("%3d %3d",NewX,NewY);//Debug
        /*Clear the plane in the old position*/
        TP(x,y,OC,' ');
        TP(x+1,y-1,OC,' '),TP(x+1,y+1,OC,' ');
        for(int i=y-5;i<=y+5;i++) TP(x+2,i,OC,' ');
        TP(x+3,y,OC,' ');
        TP(x+4,y-1,OC,' '),TP(x+4,y,OC,' '),TP(x+4,y+1,OC,' ');
        /*Move the blood line*/
        BloodRefresh(NewX,NewY);
        /*Print in the new position*/
        x=NewX,y=NewY;
        TP(x,y,OC,'^');
        TP(x+1,y-1,OC,'/'),TP(x+1,y+1,OC,'\\');
        TP(x+2,y-5,OC,'|');for(int i=y-4;i<=y+4;i++)TP(x+2,i,OC,'-');TP(x+2,y+5,OC,'|');
        TP(x+3,y,OC,'|');
        TP(x+4,y-1,OC,'-'),TP(x+4,y,OC,'-'),TP(x+4,y+1,OC,'-');
        /*Refresh the bullets*/
    }
    void Shot(){
        /*Buff 5*/
        /*Faster shot*/
        int t=clock();
        if(Buffs[5]==1)
            ShotSpeed+=100,Buffs[5]=-1;
        if(Buffs[5]==-1&&t-GetBuffTime[5]>=ConstBuffLastTime[5]){
            ShotSpeed-=100;
            Buffs[5]=0;
            GetBuffTime[5]=0;
        }
        if(!ShotSpeed||LastShotTime>=t-(1000-ShotSpeed*AddShotSpeed))
            return;
        LastShotTime=t;
        if(x>0){
            OwnShotTimes++;
            int Type=1;
            /*Buff 3*/
            /*Get bullets more powerful*/
            if(Buffs[3]){
                if(t-GetBuffTime[3]>=ConstBuffLastTime[3])
                    Buffs[3]=0,GetBuffTime[3]=0;
                else
                    Type=3;
            }
            Ammo.insert(new Bullet(1,x-1,y,Type,-1,0));
            /*Buff 1*/
            /*5 lines of bullets*/
            if(Buffs[1]){
                if(t-GetBuffTime[1]>=ConstBuffLastTime[1]){
                    Buffs[1]=0;
                    GetBuffTime[1]=0;
                    return;
                }
                Ammo.insert(new Bullet(1,x-1,y-2,Type,-1,0));
                Ammo.insert(new Bullet(1,x-1,y-1,Type,-1,0));
                Ammo.insert(new Bullet(1,x-1,y+1,Type,-1,0));
                Ammo.insert(new Bullet(1,x-1,y+2,Type,-1,0));
            }
        }
    }
}Own;

struct Buff{
    int x,y;
    int Type;
    int DisappearTime;
    Buff(){}
    Buff(int t){x=rand()%(WINDOWC-3)+1,y=rand()%(WINDOWW-2)+1,Type=t,DisappearTime=clock()+ConstBuffAppearTime[t];}
};
set<Buff*> BuffIn;
int LastBuffAppearTime;
int BuffAppearCD=3000;
void BuffRefresh(){
    int T=clock();
    /*New buff in the screen*/
    if(LastBuffAppearTime+BuffAppearCD<=T){
        int id=rand();
        int t=ConstBuffAppearPossibility[BossFlag][id%10];
        if(t)
            BuffIn.insert(new Buff(t));
        LastBuffAppearTime=T;
    }
    vector<set<Buff*>::iterator> Throw;
    for(set<Buff*>::iterator it=BuffIn.begin();it!=BuffIn.end();it++){
        Buff *p=*it;
        TP(p->x,p->y,ConstBuffColor[p->Type],ConstBuffName[p->Type]);
        if(Own.Hit(p->x,p->y)){
            /*Buff 2*/
            /*Recover 100 blood*/
            if(p->Type==2){
                Own.Blood=min(Own.Blood+100,Own.FullBlood);
                Own.BloodRefresh(Own.x,Own.y);
            }
            else{
                Own.Buffs[p->Type]=1;
                Own.GetBuffTime[p->Type]=T;
            }
            Throw.push_back(it);
            TP(p->x,p->y,OC,' ');
        }
        else if(T>=p->DisappearTime){
            Throw.push_back(it);
            TP(p->x,p->y,OC,' ');
        }
    }
    for(int i=0;i<int(Throw.size());i++)
        BuffIn.erase(Throw[i]);
    //for(int i=1;i<=MAX_BUFF_NUM;i++)
    //    if(Own.Buffs[i]&&clock()-Own.GetBuffTime[i]>=ConstBuffLastTime[i])
    //        Own.Buffs[i]=0;
}


const char CHART[15]={'|','?','^','&','=','!','@',':','p','\\'};

void GameOver(){
    color(OC);
    system("cls");
    /*Get max score before*/
    LL MaxScore=0;
    LL num=((MaxScore*18-2)*38-1314)/2*100+52;
    ifstream R("./MaxScore.sc");
    if(!R.is_open())
        TP(0,0,OC,"ERROR");
    string str;
    R>>str;
    if(str.length()){
        num=0;
        for(int i=0;i<int(str.length());i++)
            if(isdigit(str[i]))
                num=num*10ll+str[i]-'0';
    }
    R.close();
    /*unlock*/
    MaxScore=(((num-52)/100*2+1314)/38+2)/18;
    TP(WINDOWC/2-2,(WINDOWW+40-10)/2,fred+flight+bblack,"Game Over!");
    TP(WINDOWC/2-1,(WINDOWW+40-15)/2,OC,"Your score: ");
    gto(WINDOWC/2-1,(WINDOWW+40-15)/2+12),color(OC),printf("%08lld",Own.Score+Own.BossScore);
    TP(WINDOWC/2,(WINDOWW+40-15)/2,OC,"MaxScore: ");
    gto(WINDOWC/2,(WINDOWW+40-15)/2+12),color(OC),printf("%08lld",max(Own.Score+Own.BossScore,MaxScore));
    if(Own.Score+Own.BossScore>MaxScore){
        TP(WINDOWC/2+1,(WINDOWW+40-15)/2+2,fred+flight+bblack,"(Refreshed!)"),MaxScore=Own.Score+Own.BossScore;
        /*lock*/
        num=((MaxScore*18-2)*38-1314)/2*100+52;
        string New;
        for(int i=1;i<=30;i++){
            if(rand()%2)
                New+=CHART[rand()%10];
            else if(num)
                New+=num%10+'0',num/=10;
        }
        while(num)
            New+=num%10+'0',num/=10;
        while(New.length()<30)
            New+=CHART[rand()%10];
        reverse(New.begin(),New.end());
        fstream CLEAR("./MaxScore.sc", ios::trunc);
        CLEAR.close();
        ofstream T("./MaxScore.sc");
        if(!T.is_open())
            TP(0,0,OC,"ERROR");
        T<<New;
        T.close();
    }
    TP(WINDOWC/2+2,(WINDOWW+40-15)/2-3,OC,"(Press any key to exit)");
    getch();
    gto(WINDOWC/2+4,0),exit(0);
}

bool isHit(int,int,int);

void MoveBullet(Bullet &me){
    int t=clock();
    if(me.LastBulletRefreshTime>=t-(100-ConstBulletSpeed[me.Type]))
        return;
    me.LastBulletRefreshTime=t;
    int tx=me.x+me.dx,ty=me.y+me.dy;
    TP(me.x,me.y,OC,' ');
    /*It runs out of the screen => erase it*/
    if(tx<0||tx>=WINDOWC||ty<0||ty>=WINDOWW||isHit(tx,ty,me.Type)){
        me.isExist=0;
        return;
    }
    TP(me.x=tx,me.y=ty,ConstBulletColor[me.Type],ConstBulletShape[me.Type]);
}

#define MAX_BUFFFULLNAME_LEN 16
const int ConstBuffTipPosition[MAX_BUFF_NUM+5][2]={{0,0},{13,WINDOWW+3},{14,WINDOWW+3},{15,WINDOWW+3},{16,WINDOWW+3},{17,WINDOWW+3}};
const char ConstBuffFullName[MAX_BUFF_NUM+5][MAX_BUFFFULLNAME_LEN+5]={"","4 more bullets","recover 50 blood","more powerful","double score","shot faster"};
const int ConstMaxBuffFullNameLen[MAX_BUFF_NUM+5]={0,16,16,16,16,16};
void BuffTipRefresh(){
    /*
    TP(12,WINDOWW+3,OC,"---------Details of Buffs---------");
    TP(18,WINDOWW+3,OC,"----------------------------------");
    */
    int C=fgray;
    for(int i=1;i<=MAX_BUFF_NUM;i++){
        TP(ConstBuffTipPosition[i][0],ConstBuffTipPosition[i][1],C,ConstBuffName[i]);
        TP(ConstBuffTipPosition[i][0],ConstBuffTipPosition[i][1]+1,C,": ");
        TP(ConstBuffTipPosition[i][0],ConstBuffTipPosition[i][1]+3,C+(Own.Buffs[i]?bwhite+blight:0),ConstBuffFullName[i]);
        gto(ConstBuffTipPosition[i][0],ConstBuffTipPosition[i][1]+3+ConstMaxBuffFullNameLen[i]),color(C+(Own.Buffs[i]?bwhite+blight:0)),printf("[%02d S]",int(Own.Buffs[i]?(ConstBuffLastTime[i]-(clock()-Own.GetBuffTime[i])+999)/1000:0));
    }
}

void EnemyClear(){
    int tmp=UFORefreshTime;
    UFORefreshTime=INF;
    for(set<UFO*>::iterator it=Enemy.begin();it!=Enemy.end();it++)
        (*it)->isExist=0;
    UFORefresh();
    UFORefreshTime=tmp;
}

double Performance();

//D C B A S
const int PerfColor[10]={fblack+bwhite,fgray+bwhite,fpurple+bwhite,fgreen+bwhite,fred+bwhite};
const char PerfLevel[10][8]={"D.","C.","B.","A!","S!!"};

struct BOSS{
    /*Shape of the boss:
      0000000/0000000           (x-7,y-7) to (x-7,y+7)
      @@@@@@@@@@@@@@@           (x-6,y-7) to (x-6,y+7)
     (OOOOOOOOOOOOOOO)
       [-----------]            (x-5,y-6) to (x-5,y+6)
         \OOXXXOO/              (x-4,y-4) to (x-4,y+4)
      +---\XXOXX/---+           (x-3,y-7) to (x-3,y+7)
      V    \OOO/    V           (x-2,y-7) to (x-2,y+7)
            \O/                 (x-1,y-1) to (x-1,y+1)
             V                  (x,y)
    */
    int isExist;
    int x,y;//position of the head
    int dx,dy;
    int Blood,FullBlood;
    int ShotSpeed1,ShotSpeed2,LastShotTime1,LastShotTime2,flag2;
    int MoveSpeed,LastMoveTime;
    int Score,AppearTime;
    int StopCD,StopTime,LastStopTime,isStop;
    int Money;
    bool Hit(int tx,int ty){
        return (tx==x-5&&ty>=y-6&&ty<=y+6)||
               (tx==x-4&&ty>=y-4&&ty<=y+4)||
               (tx==x-3&&ty>=y-7&&ty<=y+7)||
               (tx==x-2&&((ty==y-7)||(ty==y+7)||(ty>=y-2&&ty<=y+2)))||
               (tx==x-1&&ty>=y-1&&ty<=y+1)||
               (tx==x&&ty==y);
    }
    void Die(){
        flash(3);
        BossFlag=0;
        double tmp=Performance();
        int Add=int(Score*tmp);
        Own.BossScore+=Add;
        Own.Money+=Money*(tmp/3.0);
        ScoreFlash=MoneyFlash=1;
        TP(WINDOWC/2-1,WINDOWW/2-18,OC,"+-----------------------------------+");
        TP(WINDOWC/2  ,WINDOWW/2-18,OC,'|'),gto(WINDOWC/2,WINDOWW/2-7),color(PerfColor[int(tmp)]),printf("%s",PerfLevel[int(tmp)]),printf("  + %d scores !",Add),TP(WINDOWC/2  ,WINDOWW/2+18,OC,'|');
        TP(WINDOWC/2+1,WINDOWW/2-18,OC,"+-----------------------------------+");
        Sleep(1500);
        TP(WINDOWC/2-1,WINDOWW/2-18,OC,"                                     ");
        TP(WINDOWC/2  ,WINDOWW/2-18,OC,"                                     ");
        TP(WINDOWC/2+1,WINDOWW/2-18,OC,"                                     ");
        if(x-7>=0) TP(x-7,y-7,OC,"               ");
        if(x-6>=0) TP(x-6,y-7,OC,"               ");
        if(InRange(x)) TP(x,y,OC,' ');
        if(InRange(x-1)) TP(x-1,y-1,OC,"   ");
        if(InRange(x-2)) TP(x-2,y-7,OC,"               ");
        if(InRange(x-3)) TP(x-3,y-7,OC,"               ");
        if(InRange(x-4)) TP(x-4,y-4,OC,"         ");
        if(InRange(x-5)) TP(x-5,y-6,OC,"             ");
        EnemyClear();
    }
    void Flash(){
        if(InRange(x-5)) TP(x-5,y-6,fblack+bwhite,"[-----------]");
        if(InRange(x-4)) TP(x-4,y-4,fblack+bwhite,'\\'),TP(x-4,y-3,fblack+bwhite,"OO"),TP(x-4,y-1,fblack+bwhite,"XXX"),TP(x-4,y+2,fblack+bwhite,"OO"),TP(x-4,y+4,fblack+bwhite,"/");
        if(InRange(x-3)) TP(x-3,y-7,fblack+bwhite,"+---\\XX"),TP(x-3,y,fblack+bwhite,'O'),TP(x-3,y+1,fblack+bwhite,"---+");
        if(InRange(x-2)) TP(x-2,y-7,fblack+bwhite,'V'),TP(x-2,y-2,fblack+bwhite,'\\'),TP(x-2,y-1,fblack+bwhite,"OOO"),TP(x-2,y+2,fblack+bwhite,'/'),TP(x-2,y+7,fblack+bwhite,'V');
        if(InRange(x-1)) TP(x-1,y-1,fblack+bwhite,'\\'),TP(x-1,y,fblack+bwhite,'O'),TP(x-1,y+1,fblack+bwhite,'/');
        if(InRange(x-5)) TP(x-5,y-6,OC,"[-----------]");
        if(InRange(x-4)) TP(x-4,y-4,OC,'\\'),TP(x-4,y-3,fgray+bblack,"OO"),TP(x-4,y-1,OC,"XXX"),TP(x-4,y+2,fgray+bblack,"OO"),TP(x-4,y+4,OC,"/");
        if(InRange(x-3)) TP(x-3,y-7,OC,"+---\\XX"),TP(x-3,y,fgray+bblack,'O'),TP(x-3,y+1,OC,"---+");
        if(InRange(x-2)) TP(x-2,y-7,fgray+bblack,'V'),TP(x-2,y-2,OC,'\\'),TP(x-2,y-1,fgray+bblack,"OOO"),TP(x-2,y+2,OC,'/'),TP(x-2,y+7,fgray+bblack,'V');
        if(InRange(x-1)) TP(x-1,y-1,OC,'\\'),TP(x-1,y,fgray+bblack,'O'),TP(x-1,y+1,OC,'/');
        if(InRange(x)) TP(x,y,OC,' ');
        if(InRange(x)) TP(x,y,OC,'V');
    }
    void Init(int S){
        Blood=FullBlood=ConstBossFullBlood[S];
        x=0,y=rand()%(WINDOWW-14)+7;//Must be in the screen
        dx=1,dy=0;
        LastShotTime1=LastShotTime2=0;
        flag2=0;
        ShotSpeed1=ConstBossShotSpeed[S][0],ShotSpeed2=ConstBossShotSpeed[S][1];
        MoveSpeed=ConstBossMoveSpeed[S];
        LastMoveTime=0;
        Score=ConstBossScore[S];
        AppearTime=clock();
        isExist=1;
        StopTime=ConstBossStopTime[S],StopCD=ConstBossStopCD[S],LastStopTime=isStop=0;
        Money=ConstBossMoney[S];
    }
    void BloodRefresh(int NewX,int NewY){
        /*Print the blood/fullblood number*/
        /*Due to %06d we can't use TP*/
        if(x-7>=0){
            dx=0;
            TP(x-7,y-7,OC,"               ");
            if(isExist){
                if(NewX-7<WINDOWC){
                    gto(NewX-7,NewY-7),color(fcyan+bblack),printf("%07d",Blood);
                    TP(NewX-7,NewY,fcyan+bblack,'/');
                    gto(NewX-7,NewY+1),color(fcyan+bblack),printf("%07d",FullBlood);
                }
            }
        }
        /*To appear gradually, we should check the position*/
        if(x-6>=0){
            TP(x-6,y-7,OC,"               ");
            if(isExist)
                if(NewX-6<WINDOWC){
                    /*Round up*/
                    int FullBlock=(Blood*15+FullBlood-1)/FullBlood;   //Number of "@"
                    int EmptyBlock=15-FullBlock;                       //Number of "O"
                    int BloodColor=ConstBloodColor[(FullBlock+4)/5];
                    /*Print the blood line*/
                    for(int i=1;i<=FullBlock;i++)
                        TP(NewX-6,NewY-8+i,BloodColor+bblack,'@');
                    for(int i=1;i<=EmptyBlock;i++)
                        TP(NewX-6,NewY-8+FullBlock+i,fgray+bblack,'O');
                }
        }
        if(x-7>=WINDOWC)
            isExist=0;
    }
    /*Only one boss so we don't have to make the function out*/
    void MovePrint(){
        int t=clock();
        if(LastMoveTime>=t-(1000-MoveSpeed))
            return;
        LastMoveTime=t;
        /*Change the direction*/
        if(rand()%10==0)
            dy=ConstNewDy[rand()%3];
        int NewX=x+dx,NewY=y+dy;
        if(UFOCrash(NewX,NewY)||NewY-7<0||NewY+7>=WINDOWW)
            for(int i=0;i<3;i++){
                dy=ConstNewDy[rand()%3];
                NewX=x+dx,NewY=y+dy;
                if(!(UFOCrash(NewX,NewY)||NewY-7<0||NewY+7>=WINDOWW))
                    break;
            }
        if(UFOCrash(NewX,NewY)||NewY-7<0||NewY+7>=WINDOWW)
            return;
        if(InRange(x)) TP(x,y,OC,' ');
        if(InRange(NewX)) TP(NewX,NewY,OC,'V');
        if(InRange(x-1)) TP(x-1,y-1,OC,"   ");
        if(InRange(NewX-1))
            TP(NewX-1,NewY-1,OC,'\\'),
            TP(NewX-1,NewY,fgray+bblack,'O'),
            TP(NewX-1,NewY+1,OC,'/');
        if(InRange(x-2)) TP(x-2,y-7,OC,"               ");
        if(InRange(NewX-2)) TP(NewX-2,NewY-7,fgray+bblack,'V'),TP(NewX-2,NewY-2,OC,'\\'),TP(NewX-2,NewY-1,fgray+bblack,"OOO"),TP(NewX-2,NewY+2,OC,'/'),TP(NewX-2,NewY+7,fgray+bblack,'V');
        if(InRange(x-3)) TP(x-3,y-7,OC,"               ");
        if(InRange(NewX-3)) TP(NewX-3,NewY-7,OC,"+---\\XX"),TP(NewX-3,NewY,fgray+bblack,'O'),TP(NewX-3,NewY+1,OC,"XX/---+");
        if(InRange(x-4)) TP(x-4,y-4,OC,"         ");
        if(InRange(NewX-4)) TP(NewX-4,NewY-4,OC,'\\'),TP(NewX-4,NewY-3,fgray+bblack,"OO"),TP(NewX-4,NewY-1,OC,"XXX"),TP(NewX-4,NewY+2,fgray+bblack,"OO"),TP(NewX-4,NewY+4,OC,"/");
        if(InRange(x-5)) TP(x-5,y-6,OC,"             ");
        if(InRange(NewX-5)) TP(NewX-5,NewY-6,OC,"[-----------]");
        BloodRefresh(NewX,NewY);
        x=NewX,y=NewY;
    }
    void Shot(){
        int t=clock();
        if(LastShotTime1<t-(100-ShotSpeed1)){
            LastShotTime1=t;
            if(x-1>=0){
                Ammo.insert(new Bullet(1,x-1,y-7,4,1,0));
                Ammo.insert(new Bullet(1,x-1,y+7,4,1,0));
            }
        }
        if(LastShotTime2<t-(100-ShotSpeed2-500)){
            LastShotTime2=t,flag2=1;
            TP(x,y,fred+flight+bgray,'V');
        }
        if(flag2&&t>=LastShotTime2+500){
            flag2=0;
            if(x+1>=0)
                Ammo.insert(new Bullet(1,x+1,y,5,1,0));
        }
    }
}Boss;

/*There's an awful problem that set<UFO*>Enemy will be use in the struct UFO but it needs the declaration of struct UFO so we can neither put it in front of the struct UFO nor put it after the struct UFO...*/
/*So we have to get the function Crash out of the struct UFO.*/ /*Eating shit*/
/*To check if it will hit another UFO*/
void UFOMovePrint(UFO&,set<UFO*>::iterator);
bool UFOCrash(UFO me,int NewX,int NewY,set<UFO*>::iterator ID){
    for(set<UFO*>::iterator it=Enemy.begin();it!=Enemy.end();it++){
        int ox=(*it)->x,oy=(*it)->y;
        if(it==ID||ox<NewX) continue;
        if(NewX<=ox+4&&NewX>=ox-4&&NewY>=oy-8&&NewY<=oy+8){
            /*avoid disfluency*/
            UFO *New=*it;
            UFOMovePrint(*New,it);
            return 1;
        }
    }
    if(BossFlag&&NewX<=Boss.x&&NewX>=Boss.x-5&&NewY>=Boss.y-9&&NewY<=Boss.y+9)
        return 1;
    return 0;
}
bool UFOCrash(int NewX,int NewY){
    for(set<UFO*>::iterator it=Enemy.begin();it!=Enemy.end();it++){
        int ox=(*it)->x,oy=(*it)->y;
        if(ox<NewX) continue;
        if(NewX<=ox+9&&NewX>=ox-9&&NewY>=oy-9&&NewY<=oy+9)
            return 1;
    }
    return 0;
}

//OwnShotTimes,OwnLoseBlood,OwnShotOnTimes;
double Performance(){//(0,5]
    double p1=double(OwnShotOnTimes)/max(OwnShotTimes,1);
    double p2=max(double(Own.FullBlood-OwnLoseBlood)/Own.FullBlood,0.0);
    return min((p1+p2)*2.5,4.999999);
}

void BossRefresh(){
    Boss.MovePrint();
    int t=clock();
    if(!Boss.isStop)
        Boss.Shot();
    if(!Boss.isStop&&Boss.LastStopTime+Boss.StopTime+Boss.StopCD<=t)
        Boss.LastStopTime=t,Boss.isStop=1;
    if(Boss.isStop&&t-Boss.LastStopTime>=Boss.StopTime)
        Boss.isStop=0;
}

void Init(){
    srand((unsigned)time(NULL));
    //SetWindow("HPF",WINDOWC+12,WINDOWW+45,0,500);
    SetWindow("HPF",WINDOWC+2,WINDOWW+40);
    HindCursor();
    TP(0,0,OC,"+---------------------------------------------------------------------------------------------+");
    TP(2,(WINDOWW+40)/2-7,OC,"Hape Flying Game");
    TP(7,0,OC,"+---------------------------------------------------------------------------------------------+");
    Button Start=NewButton(4,(WINDOWW+40)/2-4,OC,"> Start <");
    Button More=NewButton(5,(WINDOWW+40)/2-4,OC,"> More  <");
    while(1){
        if(Preserve(Start)){
            Own.Init(0);
            break;
        }
        if(Preserve(More)){
            TP(6,3,fred,"Input the password: ");
            gto(6,22),color(fgray);
            char Key[15];
            fgets(Key,10,stdin);
            if(!strcmp(Key,"cxhsdsb\n")){
                Own.Init(1);
                break;
            }
            fflush(stdin);
            color(OC);
            system("cls");
            TP(0,0,OC,"+---------------------------------------------------------------------------------------------+");
            TP(2,(WINDOWW+40)/2-7,OC,"Hape Flying Game");
            TP(7,0,OC,"+---------------------------------------------------------------------------------------------+");
        }
        Sleep(50);
    }
    color(OC);
    system("cls");
}

/*Meet the awful problem again*/
bool isHit(int NewX,int NewY,int Type){
    if(Type==1||Type==3){
        int DM=int(ConstBulletDamage[Type]*Own.AddAtack);
        for(set<UFO*>::iterator it=Enemy.begin();it!=Enemy.end();it++){
            if((*it)->Hit(NewX,NewY)){
                /*Mention the order, or it won't be cleared*/
                UFO *t=*it;
                t->Flash();
                t->Blood=max(t->Blood-DM,0);
                t->BloodRefresh(t->x,t->y);
                if(t->Blood<=0){
                    Own.Money+=t->Money;
                    MoneyFlash=1;
                    ScoreFlash=1;
                    t->isExist=0;
                    t->ClearPrint();
                    int Add=t->Score;
                    /*Buff 4*/
                    /*Double score*/
                    if(Own.Buffs[4]){
                        if(Own.GetBuffTime[4]+ConstBuffLastTime[4]>=clock()){
                            Own.Buffs[4]=0;
                            Own.GetBuffTime[4]=0;
                        }
                        Add+=t->Score;
                    }
                    if(BossFlag)
                        Add/=10;
                    Own.Score+=Add;
                }
                return 1;
            }
        }
        if(BossFlag&&Boss.Hit(NewX,NewY)){
            Boss.Flash();
            Boss.Blood=max(Boss.Blood-DM/2,0);
            Boss.BloodRefresh(Boss.x,Boss.y);
            OwnShotOnTimes++;
            if(Boss.Blood<=0)
                Boss.Die(),BossFlag=0;
            return 1;
        }
    }
    else if(Own.Hit(NewX,NewY)){
        Own.Flash(fred+flight);
        OwnLoseBlood+=min(Own.Blood,ConstBulletDamage[Type]);
        Own.Blood=max(Own.Blood-ConstBulletDamage[Type],0);
        Own.BloodRefresh(Own.x,Own.y);
        if(Own.Blood<=0)
            GameOver();
        return 1;
    }
    return 0;
}

#define MAX_GRADE 10
const int ConstUpgradeCost[MAX_GRADE+5]={10,20,50,100,200,500,1000,2000,5000,10000,INF};
const char ConstUpgradeCostStr[MAX_GRADE+5][10]={"(M 10)","(M 20)","(M 50)","(M 100)","(M 200)","(M 500)","(M 1000)","(M 2000)","(M 5000)","(M 10000)","(M INF)  "};
const int ConstGradeColor[MAX_GRADE+5]={fgreen+flight+bblack,fgreen+flight+bblack,fgreen+bblack,fblue+flight+bblack,fblue+flight+bblack,fblue+bblack,fyellow+flight+bblack,fyellow+bblack,fyellow+bblack,fred+flight+bblack,fred+bblack,fred+bblack};
const char ConstGradeName[MAX_GRADE+5][20]={"[G0]","[G1]","[G2]","[G3]","[G4]","[G5]","[G6]","[G7]","[G8]","[G9]","[G10]"};

int main(){
    //GameOver();
    //ColorPrint();
    //getchar();
    Init();
    HWND hd;
    hd=GetForegroundWindow();
    TP(12,WINDOWW+3,OC,"---------Details of Buffs---------");
    TP(18,WINDOWW+3,OC,"----------------------------------");
    //Own.Blood=100;
    int cnt=1;
    BossFlag=0;
    int LastT=clock()/1000-2,LastMoney=-1;
    BEGINTIME=clock();
    int _____=0,STOP=0,LastPreserveTime=-INF;

    Button AddFullBlood,AddAttack,AddShotSpeed;
    int FullBloodGrade=0,AttackGrade=0,ShotSpeedGrade=0;
    string AddFullBloodTip("> Add your max blood by 500"),AddAttackTip("> Add your attack by 10%"),AddShotSpeedTip("> Add your shot speed by 10%");
    AddFullBlood=NewButton(5,WINDOWW+3,OC,"> Add your max blood by 200");
    AddAttack=NewButton(6,WINDOWW+3,OC,"> Add your attack by 10%");
    AddShotSpeed=NewButton(7,WINDOWW+3,OC,"> Add your shot speed by 5%");
    //Own.Money=10000000;
    while(1){
        if(!STOP){
            if(_____%10==0){
                gto(0,0),color(OC);
                for(int i=1;i<=WINDOWW+40;i++)
                    putchar('-');
                gto(WINDOWC,0),color(OC);
                for(int i=1;i<=WINDOWW+40;i++)
                    putchar('-');
            }
            _____++;
            POINT k;
            GetPos(k);
            Own.MovePrint(min(max(int(k.x)-3,1),WINDOWC-1),min(max(int(k.y),0),WINDOWW-1));
            if(KEY_DOWN(MOUSE_MOVED))
                Own.Shot();
            BulletsRefresh();
            if(BossFlag)
                BossRefresh();
            UFORefresh();
            BuffRefresh(),BuffTipRefresh();
            if(ScoreFlash){
                ScoreFlash=0;
                TP(10,WINDOWW+3,fred+flight+bwhite,"[ "),
                TP(10,WINDOWW+5,OC-bblack+bwhite,"Score: "),
                gto(10,WINDOWW+12),color(OC-bblack+bwhite),printf("%04lld + %08lld",Own.Score,Own.BossScore),
                TP(10,WINDOWW+27,fred+flight+bwhite," ]");
                Sleep(100);
            }
            TP(10,WINDOWW+3,fred+flight+bblack,"[ "),
            TP(10,WINDOWW+5,OC,"Score: "),
            gto(10,WINDOWW+12),color(OC),printf("%04lld + %08lld",Own.Score,Own.BossScore),
            TP(10,WINDOWW+27,fred+flight+bblack," ]");
            int T=(clock()-BEGINTIME)/1000;
            if(T!=LastT){
                TP(9,WINDOWW+3,fred+flight+bblack,"[ "),TP(9,WINDOWW+5,OC,"Time: "),gto(9,WINDOWW+11),color(OC),printf("%05d",T),TP(9,WINDOWW+16,fred+flight+bblack," ]");
                LastT=T;
            }
        }
        if(Own.Money!=LastMoney){
            if(MoneyFlash){
                MoneyFlash=0;
                TP(1,WINDOWW+3,fred+flight+bwhite,"[ "),
                TP(1,WINDOWW+6,OC-bblack+bwhite,"Money: "),
                gto(1,WINDOWW+13),color(OC-bblack+bwhite),printf("%08d",LastMoney=Own.Money),
                TP(1,WINDOWW+21,fred+flight+bwhite," ]");
                Sleep(100);
            }
            TP(1,WINDOWW+3,fred+flight+bblack,"[ "),
            TP(1,WINDOWW+6,OC,"Money: "),
            gto(1,WINDOWW+13),color(OC),printf("%08d",LastMoney=Own.Money),
            TP(1,WINDOWW+21,fred+flight+bblack," ]");

        }
        if(clock()-LastPreserveTime>=100){
            LastPreserveTime=clock();
            if(Preserve(AddFullBlood)){
                if(Own.Money>=ConstUpgradeCost[FullBloodGrade]){
                    Own.Money-=ConstUpgradeCost[FullBloodGrade];
                    Own.FullBlood+=200;
                    MoneyFlash=1;
                    FullBloodGrade++;
                }
            }
            if(Preserve(AddAttack)){
                if(Own.Money>=ConstUpgradeCost[AttackGrade]){
                    Own.Money-=ConstUpgradeCost[AttackGrade];
                    Own.AddAtack+=0.1;
                    MoneyFlash=1;
                    AttackGrade++;
                }
            }
            if(Preserve(AddShotSpeed)){
                if(Own.Money>=ConstUpgradeCost[ShotSpeedGrade]){
                    Own.Money-=ConstUpgradeCost[ShotSpeedGrade];
                    Own.AddShotSpeed+=0.05;
                    MoneyFlash=1;
                    ShotSpeedGrade++;
                }
            }
            TP(5,WINDOWW+31,ConstGradeColor[FullBloodGrade+1],ConstUpgradeCostStr[FullBloodGrade]);
            TP(2,WINDOWW+3,OC,"Max Blood: "),gto(2,WINDOWW+18),color(OC),printf("%06d",Own.FullBlood);
            TP(2,WINDOWW+25,ConstGradeColor[FullBloodGrade],ConstGradeName[FullBloodGrade]);
            Own.MovePrint(Own.x,Own.y,0);
            TP(6,WINDOWW+31,ConstGradeColor[AttackGrade+1],ConstUpgradeCostStr[AttackGrade]);
            TP(3,WINDOWW+3,OC,"Attack: "),gto(3,WINDOWW+18),color(OC),printf("%06d",int((Own.Buffs[3]?ConstBulletDamage[3]:ConstBulletDamage[1])*Own.AddAtack));
            TP(3,WINDOWW+25,ConstGradeColor[AttackGrade],ConstGradeName[AttackGrade]);
            TP(7,WINDOWW+31,ConstGradeColor[ShotSpeedGrade+1],ConstUpgradeCostStr[ShotSpeedGrade]);
            TP(4,WINDOWW+3,OC,"Attack Speed: "),gto(4,WINDOWW+18),color(OC),printf("%06d",int(Own.ShotSpeed*Own.AddShotSpeed));
            TP(4,WINDOWW+25,ConstGradeColor[ShotSpeedGrade],ConstGradeName[ShotSpeedGrade]);
        }
        if(kbhit()){
            char c=getch();
            if(c==' '){
                if(!STOP){
                    TP(WINDOWC/2-1,WINDOWW/2-16,OC,"+----------------------------------+");
                    TP(WINDOWC/2  ,WINDOWW/2-16,OC,"|   Press space bar to continue.   |");
                    TP(WINDOWC/2+1,WINDOWW/2-16,OC,"+----------------------------------+");
                    STOP=1;
                }
                else{
                    TP(WINDOWC/2-1,WINDOWW/2-16,OC,"                                    ");
                    TP(WINDOWC/2  ,WINDOWW/2-16,OC,"                                    ");
                    TP(WINDOWC/2+1,WINDOWW/2-16,OC,"                                    ");
                    STOP=0;
                    RECT W;
                    GetWindowRect(hd,&W);
                    SetCursorPos(W.left+Own.y*8+10,W.top+Own.x*16+80);
                }
            }
        }
        /*Boos*/
        if(!BossFlag&&Own.NeedBoss()){
        //if(!BossFlag)
            Sleep(200);
            flash(3);
            OwnShotTimes=OwnLoseBlood=OwnShotOnTimes=0;
            EnemyClear();
            //UFORefreshTime=5000;
            //BuffAppearCD=5000;
            Boss.Init(cnt);
            BossFlag=1;
            cnt++;
        }
    }
}
