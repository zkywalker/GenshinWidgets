package org.zky.genshinwidgets.model

data class GetCharacter(val avatars: List<GameCharacter>, val role: UserRole)

//{
//  "retcode": 0,
//  "message": "OK",
//  "data": {
//    "avatars": [
//      {
//        "id": 10000002,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Ayaka@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Ayaka.png",
//        "name": "神里绫华",
//        "element": "Cryo",
//        "fetter": 10,
//        "level": 90,
//        "rarity": 5,
//        "weapon": {
//          "id": 11414,
//          "name": "天目影打刀",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Sword_Bakufu.png",
//          "type": 1,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "单手剑",
//          "desc": "传说中连以神速见长的天狗都能斩落的名士订制的刀。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 71543,
//            "name": "历经风雪的思念",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14001_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2140011,
//              "name": "冰风迷途的勇士",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%冰元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "攻击处于冰元素影响下的敌人时，暴击率提高20%；若敌人处于冻结状态下，则暴击率额外提高20%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 71523,
//            "name": "摧冰而行的执望",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14001_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2140011,
//              "name": "冰风迷途的勇士",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%冰元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "攻击处于冰元素影响下的敌人时，暴击率提高20%；若敌人处于冻结状态下，则暴击率额外提高20%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 71553,
//            "name": "冰雪故园的终期",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14001_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2140011,
//              "name": "冰风迷途的勇士",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%冰元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "攻击处于冰元素影响下的敌人时，暴击率提高20%；若敌人处于冻结状态下，则暴击率额外提高20%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 90514,
//            "name": "沉波之盏",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15016_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150161,
//              "name": "沉沦之心",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%水元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技后的15秒内，普通攻击与重击造成的伤害提高30%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 71533,
//            "name": "破冰踏雪的回音",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14001_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2140011,
//              "name": "冰风迷途的勇士",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%冰元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "攻击处于冰元素影响下的敌人时，暴击率提高20%；若敌人处于冻结状态下，则暴击率额外提高20%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 21,
//            "name": "霜杀墨染樱",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayaka_01.png",
//            "effect": "神里绫华的普通攻击或重击对敌人造成<color=#99FFFFFF>冰元素伤害</color>时，有50%的几率使<color=#FFD780FF>神里流·冰华</color>的冷却时间缩减0.3秒。该效果每0.1秒只能触发一次。",
//            "is_actived": false,
//            "pos": 1
//          },
//          {
//            "id": 22,
//            "name": "三重雪关扉",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayaka_02.png",
//            "effect": "施放<color=#FFD780FF>神里流·霜灭</color>时，会额外释放两股规模较小的霜见雪关扉，各自能造成原本20%的伤害。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 23,
//            "name": "花白锦画纸吹雪",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ayaka_02.png",
//            "effect": "<color=#FFD780FF>神里流·霜灭</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 24,
//            "name": "盈缺流返",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayaka_03.png",
//            "effect": "敌人受到<color=#FFD780FF>神里流·霜灭</color>的霜见雪关扉造成的伤害后，防御力降低30%，持续6秒。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 25,
//            "name": "花云钟入月",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ayaka_01.png",
//            "effect": "<color=#FFD780FF>神里流·冰华</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 26,
//            "name": "间水月",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayaka_04.png",
//            "effect": "每过10秒，神里绫华会获得「薄冰舞踏」，使重击造成的伤害提高298%。薄冰舞踏效果将在重击命中敌人的0.5秒后清除，并重新开始计算时间。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 0,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000030,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Zhongli@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Zhongli.png",
//        "name": "钟离",
//        "element": "Geo",
//        "fetter": 10,
//        "level": 90,
//        "rarity": 5,
//        "weapon": {
//          "id": 13303,
//          "name": "黑缨枪",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Pole_Noire.png",
//          "type": 13,
//          "rarity": 3,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "长柄武器",
//          "desc": "解决了白缨容易弄脏问题的绝世好枪。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 91544,
//            "name": "勋绩之花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15017_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150171,
//              "name": "千岩牢固",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "生命值提升20%"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "元素战技命中敌人后，使队伍中附近的所有角色攻击力提升20%，护盾强效提升30%，持续3秒。该效果每0.5秒至多触发一次。装备此圣遗物套装的角色处于队伍后台时，依然能触发该效果。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 91523,
//            "name": "昭武翎羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15017_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150171,
//              "name": "千岩牢固",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "生命值提升20%"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "元素战技命中敌人后，使队伍中附近的所有角色攻击力提升20%，护盾强效提升30%，持续3秒。该效果每0.5秒至多触发一次。装备此圣遗物套装的角色处于队伍后台时，依然能触发该效果。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 81553,
//            "name": "宗室时计",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15007_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150071,
//              "name": "昔日宗室之仪",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素爆发造成的伤害提升20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，队伍中所有角色攻击力提升20%，持续12秒。该效果不可叠加。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 91514,
//            "name": "盟誓金爵",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15017_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150171,
//              "name": "千岩牢固",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "生命值提升20%"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "元素战技命中敌人后，使队伍中附近的所有角色攻击力提升20%，护盾强效提升30%，持续3秒。该效果每0.5秒至多触发一次。装备此圣遗物套装的角色处于队伍后台时，依然能触发该效果。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 91534,
//            "name": "将帅兜鍪",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15017_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150171,
//              "name": "千岩牢固",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "生命值提升20%"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "元素战技命中敌人后，使队伍中附近的所有角色攻击力提升20%，护盾强效提升30%，持续3秒。该效果每0.5秒至多触发一次。装备此圣遗物套装的角色处于队伍后台时，依然能触发该效果。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 301,
//            "name": "岩者，六合引之为骨",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Zhongli_01.png",
//            "effect": "<color=#FFD780FF>地心</color>创造的岩脊至多可以同时存在2个。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 302,
//            "name": "石者，八荒韫玉而明",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Zhongli_02.png",
//            "effect": "<color=#FFD780FF>天星</color>陨落时，会为附近的当前场上角色赋予玉璋护盾。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 303,
//            "name": "圭璋，暝仍不移其晖",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Zhongli_01.png",
//            "effect": "<color=#FFD780FF>地心</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 304,
//            "name": "黄琮，破而不夺其坚",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Zhongli_03.png",
//            "effect": "<color=#FFD780FF>天星</color>的影响范围扩大20%。\\n此外，天星的石化效果持续时间延长2秒。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 305,
//            "name": "苍璧，驱之长昭天理",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Zhongli_02.png",
//            "effect": "<color=#FFD780FF>天星</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 306,
//            "name": "金玉，礼予天地四方",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Zhongli_04.png",
//            "effect": "玉璋护盾受到伤害时，将为当前角色恢复生命值，回复量为伤害的40%。\\n单次回复量不超过当前角色最大生命值的8%。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 2,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000049,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Yoimiya@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Yoimiya.png",
//        "name": "宵宫",
//        "element": "Pyro",
//        "fetter": 10,
//        "level": 90,
//        "rarity": 5,
//        "weapon": {
//          "id": 15405,
//          "name": "弓藏",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Bow_Recluse.png",
//          "type": 12,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "弓",
//          "desc": "布满锈迹的铁造大弓，一般人根本拿不动，遑论引弓放矢。",
//          "affix_level": 3
//        },
//        "reliquaries": [
//          {
//            "id": 93543,
//            "name": "羁缠之花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15019_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150191,
//              "name": "追忆之注连",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技时，如果角色的元素能量高于或等于15点，则会流失15点元素能量，使接下来的10秒内，普通攻击、重击、下落攻击造成的伤害提高50%，持续期间内该效果不会再次触发。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 93523,
//            "name": "思忆之矢",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15019_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150191,
//              "name": "追忆之注连",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技时，如果角色的元素能量高于或等于15点，则会流失15点元素能量，使接下来的10秒内，普通攻击、重击、下落攻击造成的伤害提高50%，持续期间内该效果不会再次触发。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 75553,
//            "name": "角斗士的希冀",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15001_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150011,
//              "name": "角斗士的终幕礼",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为单手剑、双手剑、长柄武器角色时，角色普通攻击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 93513,
//            "name": "祈望之心",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15019_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150191,
//              "name": "追忆之注连",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技时，如果角色的元素能量高于或等于15点，则会流失15点元素能量，使接下来的10秒内，普通攻击、重击、下落攻击造成的伤害提高50%，持续期间内该效果不会再次触发。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 93533,
//            "name": "无常之面",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15019_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150191,
//              "name": "追忆之注连",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技时，如果角色的元素能量高于或等于15点，则会流失15点元素能量，使接下来的10秒内，普通攻击、重击、下落攻击造成的伤害提高50%，持续期间内该效果不会再次触发。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 491,
//            "name": "赤玉琉金",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yoimiya_01.png",
//            "effect": "<color=#FFD780FF>琉金云间草</color>的琉金火光持续时间延长4秒。\\n此外，处于宵宫自己的琉金火光影响下的敌人在持续期间内被击败时，宵宫的攻击力提高20%，持续20秒。",
//            "is_actived": false,
//            "pos": 1
//          },
//          {
//            "id": 492,
//            "name": "万灯送火",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yoimiya_02.png",
//            "effect": "宵宫的<color=#FF9999FF>火元素伤害</color>造成暴击后的6秒内，宵宫获得25%<color=#FF9999FF>火元素伤害加成</color>。\\n宵宫处于队伍后台时，同样能获得该效果。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 493,
//            "name": "鼠火戏法",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Yoimiya_01.png",
//            "effect": "<color=#FFD780FF>焰硝庭火舞</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 494,
//            "name": "花火职人心得",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yoimiya_03.png",
//            "effect": "宵宫自己的琉金火光发生爆炸时，<color=#FFD780FF>焰硝庭火舞</color>的冷却时间减少1.2秒。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 495,
//            "name": "真夏宵祭锦绘",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Yoimiya_02.png",
//            "effect": "<color=#FFD780FF>琉金云间草</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 496,
//            "name": "长野原龙势流星群",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yoimiya_04.png",
//            "effect": "在<color=#FFD780FF>焰硝庭火舞</color>的持续期间内，宵宫主动进行普通攻击时，有50%几率发射一枚额外的炽焰箭，造成原本60%的伤害。该伤害视为普通攻击伤害。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 0,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000052,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Shougun@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Shougun.png",
//        "name": "雷电将军",
//        "element": "Electro",
//        "fetter": 10,
//        "level": 90,
//        "rarity": 5,
//        "weapon": {
//          "id": 13502,
//          "name": "天空之脊",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Pole_Dvalin.png",
//          "type": 13,
//          "rarity": 5,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "长柄武器",
//          "desc": "象征风龙坚定决心的长枪。直挺的枪杆直指天穹，蕴含苍空与长风的力量。",
//          "affix_level": 1
//        },
//        "reliquaries": [
//          {
//            "id": 94543,
//            "name": "明威之镡",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 94524,
//            "name": "切落之羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 94553,
//            "name": "雷云之笼",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 77513,
//            "name": "吟游者之壶",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 94533,
//            "name": "华饰之兜",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 521,
//            "name": "恶曜卜词",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Shougun_01.png",
//            "effect": "<color=#FFD780FF>诸愿百眼之轮</color>能更加迅速地积攒愿力。元素类型为<color=#FFACFFFF>雷元素</color>的角色施放元素爆发后，积攒的愿力提升80%；其他元素类型的角色施放元素爆发后，积攒的愿力提升20%",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 522,
//            "name": "斩铁断金",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Shougun_03.png",
//            "effect": "<color=#FFD780FF>奥义·梦想真说</color>的梦想一刀与梦想一心状态下的雷电将军的攻击将无视敌人60%的防御力。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 523,
//            "name": "真影旧事",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Shougun_02.png",
//            "effect": "<color=#FFD780FF>奥义·梦想真说</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 524,
//            "name": "誓奉常道",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Shougun_02.png",
//            "effect": "<color=#FFD780FF>奥义·梦想真说</color>施加的<color=#FFD780FF>梦想一心</color>状态结束后，附近的队伍中所有角色（不包括雷电将军自己）的攻击力提升30%，持续10秒。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 525,
//            "name": "凶将显形",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Shougun_01.png",
//            "effect": "<color=#FFD780FF>神变·恶曜开眼</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 526,
//            "name": "负愿前行",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Shougun_04.png",
//            "effect": "处于<color=#FFD780FF>奥义·梦想真说</color>施加的<color=#FFD780FF>梦想一心</color>状态下时，雷电将军的元素爆发伤害命中敌人时，使附近的队伍中所有角色（不包括雷电将军自己）元素爆发的冷却时间缩短1秒。\\n该效果每1秒至多触发一次，在持续期间内至多触发5次。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 2,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000060,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Yelan@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Yelan.png",
//        "name": "夜兰",
//        "element": "Hydro",
//        "fetter": 4,
//        "level": 90,
//        "rarity": 5,
//        "weapon": {
//          "id": 15411,
//          "name": "落霞",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Bow_Fallensun.png",
//          "type": 12,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "弓",
//          "desc": "以白金精制而成的宝弓，其上镶嵌着霞光闪烁的宝珠。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 94544,
//            "name": "明威之镡",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 94523,
//            "name": "切落之羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 93554,
//            "name": "朝露之时",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15019_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150191,
//              "name": "追忆之注连",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技时，如果角色的元素能量高于或等于15点，则会流失15点元素能量，使接下来的10秒内，普通攻击、重击、下落攻击造成的伤害提高50%，持续期间内该效果不会再次触发。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 94513,
//            "name": "绯花之壶",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 94533,
//            "name": "华饰之兜",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 601,
//            "name": "与谋者，以局入局",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yelan_01.png",
//            "effect": "<color=#FFD780FF>萦络纵命索</color>的可使用次数增加1次。",
//            "is_actived": false,
//            "pos": 1
//          },
//          {
//            "id": 602,
//            "name": "入彀者，多多益善",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yelan_02.png",
//            "effect": "<color=#FFD780FF>「玄掷玲珑」</color>协同攻击时，会发射一枚额外的水箭，造成相当于夜兰生命值上限14%的水元素伤害。\\n该效果每1.8秒至多触发一次。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 603,
//            "name": "晃盅者，琼畟药骰",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Yelan_01.png",
//            "effect": "<color=#FFD780FF>渊图玲珑骰</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 604,
//            "name": "诓惑者，接树移花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yelan_03.png",
//            "effect": "依照<color=#FFD780FF>「络命丝」</color>标记敌人的数量，每次标记将在爆发时使队伍中所有角色的生命值上限提升10%，持续25秒。通过这种方式，生命值上限至多获得40%提升。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 605,
//            "name": "坐庄者，三仙戏法",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Yelan_02.png",
//            "effect": "<color=#FFD780FF>萦络纵命索</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 606,
//            "name": "取胜者，大小通吃",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yelan_04.png",
//            "effect": "施放<color=#FFD780FF>渊图玲珑骰</color>后，夜兰将进入「运筹帷幄」状态：\\n夜兰的普通攻击将转为发射特殊的「破局矢」。这种箭矢具有与破局矢近似的特性，造成的伤害视为重击伤害，能造成破局矢156%的伤害。\\n\\n「运筹帷幄」状态至多持续20秒，将在夜兰发射5枚箭矢后移除。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 0,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000025,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Xingqiu@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Xingqiu.png",
//        "name": "行秋",
//        "element": "Hydro",
//        "fetter": 10,
//        "level": 84,
//        "rarity": 4,
//        "weapon": {
//          "id": 11403,
//          "name": "祭礼剑",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Sword_Fossil.png",
//          "type": 1,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "单手剑",
//          "desc": "在漫长岁月中石化的道具剑，上面的仪式性装饰依然清晰可见。拥有受时间之风冲刷的祝福力量。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 90543,
//            "name": "饰金胸花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15016_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150161,
//              "name": "沉沦之心",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%水元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技后的15秒内，普通攻击与重击造成的伤害提高30%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 81524,
//            "name": "宗室之翎",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15007_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150071,
//              "name": "昔日宗室之仪",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素爆发造成的伤害提升20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，队伍中所有角色攻击力提升20%，持续12秒。该效果不可叠加。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 81554,
//            "name": "宗室时计",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15007_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150071,
//              "name": "昔日宗室之仪",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素爆发造成的伤害提升20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，队伍中所有角色攻击力提升20%，持续12秒。该效果不可叠加。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 81513,
//            "name": "宗室银瓮",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15007_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150071,
//              "name": "昔日宗室之仪",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素爆发造成的伤害提升20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，队伍中所有角色攻击力提升20%，持续12秒。该效果不可叠加。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 90533,
//            "name": "酒渍船帽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15016_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150161,
//              "name": "沉沦之心",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%水元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技后的15秒内，普通攻击与重击造成的伤害提高30%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 251,
//            "name": "重帘留香",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xingqiu_01.png",
//            "effect": "雨帘剑的最大数量增加1柄。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 252,
//            "name": "天青现虹",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xingqiu_02.png",
//            "effect": "<color=#FFD780FF>古华剑·裁雨留虹</color>的持续时间延长3秒；\\n此外，受到剑雨攻击的敌人，<color=#80C0FFFF>水元素抗性</color>降低15%，持续4秒。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 253,
//            "name": "织诗成锦",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Xingqiu_01.png",
//            "effect": "<color=#FFD780FF>古华剑·裁雨留虹</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 254,
//            "name": "孤舟斩蛟",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xingqiu_03.png",
//            "effect": "在<color=#FFD780FF>古华剑·裁雨留虹</color>效果持续期间，<color=#FFD780FF>古华剑·画雨笼山</color>造成的伤害提升50%。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 255,
//            "name": "雨深闭门",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Xingqiu_02.png",
//            "effect": "<color=#FFD780FF>古华剑·画雨笼山</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 256,
//            "name": "万文集此",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xingqiu_04.png",
//            "effect": "<color=#FFD780FF>古华剑·裁雨留虹</color>每发动2次剑雨攻击，就大幅增强下一次剑雨攻击，并在命中敌人时为行秋恢复3点元素能量。",
//            "is_actived": true,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 6,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000039,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Diona@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Diona.png",
//        "name": "迪奥娜",
//        "element": "Cryo",
//        "fetter": 10,
//        "level": 80,
//        "rarity": 4,
//        "weapon": {
//          "id": 15303,
//          "name": "反曲弓",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Bow_Curve.png",
//          "type": 12,
//          "rarity": 3,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "弓",
//          "desc": "据说能射下苍鹰的猎弓，但能不能做到主要还得看弓手的技术。",
//          "affix_level": 1
//        },
//        "reliquaries": [
//          {
//            "id": 91543,
//            "name": "勋绩之花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15017_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 16,
//            "set": {
//              "id": 2150171,
//              "name": "千岩牢固",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "生命值提升20%"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "元素战技命中敌人后，使队伍中附近的所有角色攻击力提升20%，护盾强效提升30%，持续3秒。该效果每0.5秒至多触发一次。装备此圣遗物套装的角色处于队伍后台时，依然能触发该效果。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 74523,
//            "name": "少女飘摇的思念",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14004_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2140041,
//              "name": "被怜爱的少女",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "角色造成的治疗效果提升15%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技或元素爆发后的10秒内，队伍中所有角色受治疗效果加成提高20%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 77553,
//            "name": "终幕的时计",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 16,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 91513,
//            "name": "盟誓金爵",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15017_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 5,
//            "set": {
//              "id": 2150171,
//              "name": "千岩牢固",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "生命值提升20%"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "元素战技命中敌人后，使队伍中附近的所有角色攻击力提升20%，护盾强效提升30%，持续3秒。该效果每0.5秒至多触发一次。装备此圣遗物套装的角色处于队伍后台时，依然能触发该效果。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 77534,
//            "name": "指挥的礼帽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 17,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 391,
//            "name": "特调的余韵",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Diona_01.png",
//            "effect": "<color=#FFD780FF>最烈特调</color>的效果结束时，为迪奥娜恢复15点元素能量。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 392,
//            "name": "猫爪冰摇",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Diona_02.png",
//            "effect": "<color=#FFD780FF>猫爪冻冻</color>造成的伤害提高15%，护盾的伤害吸收量提高15%；\\n此外，命中时，将为附近的当前其他场上角色生成一个伤害吸收量为<color=#FFD780FF>猫爪冻冻</color>50%的护盾，持续5秒。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 393,
//            "name": "还、还要续杯？",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Diona_01.png",
//            "effect": "<color=#FFD780FF>最烈特调</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 394,
//            "name": "「酒业杀手」",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Diona_03.png",
//            "effect": "在<color=#FFD780FF>最烈特调</color>的领域内，迪奥娜的瞄准射击的所需的蓄力时间减少60%。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 395,
//            "name": "双份加冰",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Diona_02.png",
//            "effect": "<color=#FFD780FF>猫爪冻冻</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 396,
//            "name": "猫尾打烊之时",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Diona_04.png",
//            "effect": "处在<color=#FFD780FF>最烈特调</color>领域内的角色，依据生命值获得如下效果：\\n·生命值低于或等于50%时，受治疗加成提升30%；\\n·生命值高于50%时，元素精通提升200。",
//            "is_actived": true,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 6,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000042,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Keqing@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Keqing.png",
//        "name": "刻晴",
//        "element": "Electro",
//        "fetter": 9,
//        "level": 80,
//        "rarity": 5,
//        "weapon": {
//          "id": 11402,
//          "name": "笛剑",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Sword_Troupe.png",
//          "type": 1,
//          "rarity": 4,
//          "level": 70,
//          "promote_level": 4,
//          "type_name": "单手剑",
//          "desc": "细剑的锈迹下透露出原本华丽的装饰，挥舞时轻若无物。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 79543,
//            "name": "雷鸟的怜悯",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15005_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 12,
//            "set": {
//              "id": 2150051,
//              "name": "如雷的盛怒",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%雷元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "超载、感电、超导反应造成的伤害提升40%。触发这些元素反应时，元素战技冷却时间减少1秒。该效果每0.8秒最多触发一次。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 75523,
//            "name": "角斗士的归宿",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15001_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150011,
//              "name": "角斗士的终幕礼",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为单手剑、双手剑、长柄武器角色时，角色普通攻击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 77554,
//            "name": "终幕的时计",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 79513,
//            "name": "降雷的凶兆",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15005_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150051,
//              "name": "如雷的盛怒",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%雷元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "超载、感电、超导反应造成的伤害提升40%。触发这些元素反应时，元素战技冷却时间减少1秒。该效果每0.8秒最多触发一次。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 71533,
//            "name": "破冰踏雪的回音",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14001_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 16,
//            "set": {
//              "id": 2140011,
//              "name": "冰风迷途的勇士",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%冰元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "攻击处于冰元素影响下的敌人时，暴击率提高20%；若敌人处于冻结状态下，则暴击率额外提高20%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 421,
//            "name": "雷厉",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Keqing_01.png",
//            "effect": "雷楔存在期间再次施放<color=#FFD780FF>星斗归位</color>时，在刻晴消失与出现的位置造成50%攻击力的<color=#FFACFFFF>雷元素范围伤害</color>。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 422,
//            "name": "苛捐",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Keqing_02.png",
//            "effect": "刻晴普通攻击与重击命中受到<color=#FFACFFFF>雷元素</color>影响的敌人时，有50%几率产生一个元素微粒。\\n该效果每5秒只能触发一次。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 423,
//            "name": "登楼",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Keqing_01.png",
//            "effect": "<color=#FFD780FF>天街巡游</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 424,
//            "name": "调律",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Keqing_03.png",
//            "effect": "刻晴触发<color=#FFACFFFF>雷元素相关反应</color>后的10秒内，攻击力提升25%。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 425,
//            "name": "移灯",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Keqing_02.png",
//            "effect": "<color=#FFD780FF>星斗归位</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 426,
//            "name": "廉贞",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Keqing_04.png",
//            "effect": "进行普通攻击、重击、施放元素战技或元素爆发时，刻晴获得6%<color=#FFACFFFF>雷元素伤害加成</color>，持续8秒。\\n由普通攻击、重击、元素战技或元素爆发引起的效果分别独立存在。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 2,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000032,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Bennett@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Bennett.png",
//        "name": "班尼特",
//        "element": "Pyro",
//        "fetter": 9,
//        "level": 80,
//        "rarity": 4,
//        "weapon": {
//          "id": 11401,
//          "name": "西风剑",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Sword_Zephyrus.png",
//          "type": 1,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "单手剑",
//          "desc": "西风骑士团的制式长剑。轻快锐利之余，也能轻易导出元素力量。",
//          "affix_level": 4
//        },
//        "reliquaries": [
//          {
//            "id": 81544,
//            "name": "宗室之花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15007_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150071,
//              "name": "昔日宗室之仪",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素爆发造成的伤害提升20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，队伍中所有角色攻击力提升20%，持续12秒。该效果不可叠加。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 81523,
//            "name": "宗室之翎",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15007_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150071,
//              "name": "昔日宗室之仪",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素爆发造成的伤害提升20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，队伍中所有角色攻击力提升20%，持续12秒。该效果不可叠加。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 81554,
//            "name": "宗室时计",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15007_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 16,
//            "set": {
//              "id": 2150071,
//              "name": "昔日宗室之仪",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素爆发造成的伤害提升20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，队伍中所有角色攻击力提升20%，持续12秒。该效果不可叠加。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 74412,
//            "name": "少女片刻的闲暇",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14004_1.png",
//            "pos": 4,
//            "rarity": 4,
//            "level": 16,
//            "set": {
//              "id": 2140041,
//              "name": "被怜爱的少女",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "角色造成的治疗效果提升15%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技或元素爆发后的10秒内，队伍中所有角色受治疗效果加成提高20%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 81533,
//            "name": "宗室面具",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15007_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150071,
//              "name": "昔日宗室之仪",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素爆发造成的伤害提升20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，队伍中所有角色攻击力提升20%，持续12秒。该效果不可叠加。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 321,
//            "name": "冒险憧憬",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Bennett_01.png",
//            "effect": "<color=#FFD780FF>美妙旅程</color>的攻击力提升效果不再有生命值限制，数值上追加班尼特基础攻击力的20%。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 322,
//            "name": "踏破绝境",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Bennett_02.png",
//            "effect": "班尼特的生命值低于70%时，元素充能效率提高30%。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 323,
//            "name": "火热激情",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Bennett_01.png",
//            "effect": "<color=#FFD780FF>热情过载</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 324,
//            "name": "热情不灭",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Bennett_03.png",
//            "effect": "施放一段蓄力的<color=#FFD780FF>热情过载</color>时，在技能第二段攻击中进行普通攻击，可以施放额外的追击。\\n追击的伤害等同于第二段攻击的135%。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 325,
//            "name": "开拓的心魂",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Bennett_02.png",
//            "effect": "<color=#FFD780FF>美妙旅程</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 326,
//            "name": "烈火与勇气",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Bennett_04.png",
//            "effect": "处在<color=#FFD780FF>美妙旅程</color>领域内的队伍中当前场上单手剑、双手剑、长柄武器角色获得15%<color=#FF9999FF>火元素伤害加成</color>，并获得<color=#FF9999FF>火元素附魔</color>。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 4,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000051,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Eula@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Eula.png",
//        "name": "优菈",
//        "element": "Cryo",
//        "fetter": 8,
//        "level": 80,
//        "rarity": 5,
//        "weapon": {
//          "id": 12503,
//          "name": "松籁响起之时",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Claymore_Widsith.png",
//          "type": 11,
//          "rarity": 5,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "双手剑",
//          "desc": "如同翻弄草木的息吹一般轻盈的大剑，如同吹倒树木的飓风一般摧枯拉朽的武器。",
//          "affix_level": 1
//        },
//        "reliquaries": [
//          {
//            "id": 92544,
//            "name": "无垢之花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15018_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150181,
//              "name": "苍白之火",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "造成的物理伤害提高25%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "元素战技命中敌人后，攻击力提升9%。该效果持续7秒，至多叠加2层，每0.3秒至多触发一次。叠满2层时，2件套的效果提升100%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 92524,
//            "name": "贤医之羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15018_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150181,
//              "name": "苍白之火",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "造成的物理伤害提高25%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "元素战技命中敌人后，攻击力提升9%。该效果持续7秒，至多叠加2层，每0.3秒至多触发一次。叠满2层时，2件套的效果提升100%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 92553,
//            "name": "停摆之刻",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15018_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150181,
//              "name": "苍白之火",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "造成的物理伤害提高25%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "元素战技命中敌人后，攻击力提升9%。该效果持续7秒，至多叠加2层，每0.3秒至多触发一次。叠满2层时，2件套的效果提升100%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 75514,
//            "name": "角斗士的酣醉",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15001_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150011,
//              "name": "角斗士的终幕礼",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为单手剑、双手剑、长柄武器角色时，角色普通攻击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 92533,
//            "name": "嗤笑之面",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15018_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150181,
//              "name": "苍白之火",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "造成的物理伤害提高25%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "元素战技命中敌人后，攻击力提升9%。该效果持续7秒，至多叠加2层，每0.3秒至多触发一次。叠满2层时，2件套的效果提升100%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 511,
//            "name": "光潮的幻象",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Eula_02.png",
//            "effect": "消耗<color=#FFD780FF>冰潮的涡旋</color>的冷酷之心效果后，优菈的物理伤害加成提高30%，持续6秒，\\n每消耗一层冷酷之心，都会使这个效果的持续时间延长6秒，最多不会超过18秒。",
//            "is_actived": false,
//            "pos": 1
//          },
//          {
//            "id": 512,
//            "name": "海沫的少女",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Eula_01.png",
//            "effect": "缩短<color=#FFD780FF>冰潮的涡旋</color>长按的冷却时间，使其降低至与点按的冷却时间相同。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 513,
//            "name": "劳伦斯的血脉",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Eula_01.png",
//            "effect": "<color=#FFD780FF>凝浪之光剑</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 514,
//            "name": "自卑者的逞强",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Eula_03.png",
//            "effect": "对生命值低于50%的敌人，光降之剑造成的伤害提高25%。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 515,
//            "name": "骑士的素质",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Eula_02.png",
//            "effect": "<color=#FFD780FF>冰潮的涡旋</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 516,
//            "name": "高贵者的义务",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Eula_04.png",
//            "effect": "<color=#FFD780FF>凝浪之光剑</color>创造的光降之剑立即获得5层能量。普通攻击、元素战技或元素爆发造成伤害使其积蓄能量层数时，有50%的概率额外获得一层。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 0,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000023,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Xiangling@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Xiangling.png",
//        "name": "香菱",
//        "element": "Pyro",
//        "fetter": 6,
//        "level": 80,
//        "rarity": 4,
//        "weapon": {
//          "id": 13415,
//          "name": "「渔获」",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Pole_Mori.png",
//          "type": 13,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "长柄武器",
//          "desc": "在久远的过去，曾经闻名稻妻的大盗爱用的枪。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 94544,
//            "name": "明威之镡",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 17,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 73523,
//            "name": "渡火者的解脱",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14003_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2140031,
//              "name": "渡过烈火的贤人",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "火元素抗性提高40%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "对处于火元素影响下的敌人造成的伤害提升35%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 94553,
//            "name": "雷云之笼",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 94514,
//            "name": "绯花之壶",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 94533,
//            "name": "华饰之兜",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15020_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150201,
//              "name": "绝缘之旗印",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 231,
//            "name": "外酥里嫩",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xiangling_01.png",
//            "effect": "受到锅巴攻击的敌人，<color=#FF9999FF>火元素抗性</color>降低15%，持续6秒。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 232,
//            "name": "大火宽油",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xiangling_02.png",
//            "effect": "普通攻击的最后一击会对敌人施加持续2秒的内爆效果，持续时间结束时会发生爆炸，造成75%攻击力的<color=#FF9999FF>火元素范围伤害</color>。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 233,
//            "name": "武火急烹",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Xiangling_02.png",
//            "effect": "<color=#FFD780FF>旋火轮</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 234,
//            "name": "文火慢煨",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xiangling_03.png",
//            "effect": "<color=#FFD780FF>旋火轮</color>的持续时间延长40%。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 235,
//            "name": "锅巴凶猛",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Xiangling_01.png",
//            "effect": "<color=#FFD780FF>锅巴出击</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 236,
//            "name": "大龙卷旋火轮",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xiangling_04.png",
//            "effect": "<color=#FFD780FF>旋火轮</color>持续期间，队伍中所有角色获得15%<color=#FF9999FF>火元素伤害加成</color>。",
//            "is_actived": true,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 6,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000048,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Feiyan@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Feiyan.png",
//        "name": "烟绯",
//        "element": "Pyro",
//        "fetter": 6,
//        "level": 80,
//        "rarity": 4,
//        "weapon": {
//          "id": 14407,
//          "name": "万国诸海图谱",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Catalyst_Exotic.png",
//          "type": 10,
//          "rarity": 4,
//          "level": 80,
//          "promote_level": 5,
//          "type_name": "法器",
//          "desc": "详尽记载了大陆周边海流气候的海图，是从异国经由商路流落到璃月的奇异典籍。",
//          "affix_level": 3
//        },
//        "reliquaries": [
//          {
//            "id": 80543,
//            "name": "魔女的炎之花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15006_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 6,
//            "set": {
//              "id": 2150061,
//              "name": "炽烈的炎之魔女",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%火元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "超载、燃烧反应造成的伤害提升40%，蒸发、融化反应的加成系数提高15%。施放元素战技后的10秒内，2件套的效果提高50%，该效果最多叠加3次。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 80523,
//            "name": "魔女常燃之羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15006_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150061,
//              "name": "炽烈的炎之魔女",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%火元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "超载、燃烧反应造成的伤害提升40%，蒸发、融化反应的加成系数提高15%。施放元素战技后的10秒内，2件套的效果提高50%，该效果最多叠加3次。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 80554,
//            "name": "魔女破灭之时",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15006_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 9,
//            "set": {
//              "id": 2150061,
//              "name": "炽烈的炎之魔女",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%火元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "超载、燃烧反应造成的伤害提升40%，蒸发、融化反应的加成系数提高15%。施放元素战技后的10秒内，2件套的效果提高50%，该效果最多叠加3次。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 80412,
//            "name": "魔女的心之火",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15006_1.png",
//            "pos": 4,
//            "rarity": 4,
//            "level": 5,
//            "set": {
//              "id": 2150061,
//              "name": "炽烈的炎之魔女",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%火元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "超载、燃烧反应造成的伤害提升40%，蒸发、融化反应的加成系数提高15%。施放元素战技后的10秒内，2件套的效果提高50%，该效果最多叠加3次。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 80533,
//            "name": "焦灼的魔女帽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15006_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150061,
//              "name": "炽烈的炎之魔女",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%火元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "超载、燃烧反应造成的伤害提升40%，蒸发、融化反应的加成系数提高15%。施放元素战技后的10秒内，2件套的效果提高50%，该效果最多叠加3次。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 481,
//            "name": "占理不饶人",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Feiyan_01.png",
//            "effect": "烟绯进行重击时，每持有一枚丹火印，都会提高烟绯在咏唱期间的抗打断能力，并额外降低本次重击10%的体力消耗。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 482,
//            "name": "最终解释权",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Feiyan_02.png",
//            "effect": "烟绯的重击对于生命值低于50%的敌人，暴击率提高20%。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 483,
//            "name": "真火炼宝印",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Feiyan_01.png",
//            "effect": "<color=#FFD780FF>丹书立约</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 484,
//            "name": "丹书金铁券",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Feiyan_03.png",
//            "effect": "施放<color=#FFD780FF>凭此结契</color>时：\\n生成一个伤害吸收量等于生命值上限45%的护盾，持续15秒。\\n该护盾对<color=#FF9999FF>火元素伤害</color>有250%的吸收效果。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 485,
//            "name": "遵法切结书",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Feiyan_02.png",
//            "effect": "<color=#FFD780FF>凭此结契</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 486,
//            "name": "是额外条款",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Feiyan_04.png",
//            "effect": "烟绯持有的丹火印最大数量增加一枚。",
//            "is_actived": true,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 6,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000022,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Venti@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Venti.png",
//        "name": "温迪",
//        "element": "Anemo",
//        "fetter": 4,
//        "level": 80,
//        "rarity": 5,
//        "weapon": {
//          "id": 15402,
//          "name": "绝弦",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Bow_Troupe.png",
//          "type": 12,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "弓",
//          "desc": "曾经作为乐器大放异彩的弓。如今已经不再能令人起舞。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 76544,
//            "name": "野花记忆的绿野",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15002_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150021,
//              "name": "翠绿之影",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%风元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "扩散反应造成的伤害提升60%。根据扩散的元素类型，降低受到影响的敌人40%的对应元素抗性，持续10秒。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 76523,
//            "name": "猎人青翠的箭羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15002_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150021,
//              "name": "翠绿之影",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%风元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "扩散反应造成的伤害提升60%。根据扩散的元素类型，降低受到影响的敌人40%的对应元素抗性，持续10秒。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 76554,
//            "name": "翠绿猎人的笃定",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15002_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150021,
//              "name": "翠绿之影",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%风元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "扩散反应造成的伤害提升60%。根据扩散的元素类型，降低受到影响的敌人40%的对应元素抗性，持续10秒。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 76514,
//            "name": "翠绿猎人的容器",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15002_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150021,
//              "name": "翠绿之影",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%风元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "扩散反应造成的伤害提升60%。根据扩散的元素类型，降低受到影响的敌人40%的对应元素抗性，持续10秒。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 76533,
//            "name": "翠绿的猎人之冠",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15002_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150021,
//              "name": "翠绿之影",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%风元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "扩散反应造成的伤害提升60%。根据扩散的元素类型，降低受到影响的敌人40%的对应元素抗性，持续10秒。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 221,
//            "name": "弦发的苍风",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Venti_01.png",
//            "effect": "<color=#FFD780FF>瞄准射击</color>会额外发射两枚分裂箭，分别造成原本33%的伤害。",
//            "is_actived": false,
//            "pos": 1
//          },
//          {
//            "id": 222,
//            "name": "眷恋的泠风",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Venti_02.png",
//            "effect": "<color=#FFD780FF>高天之歌</color>会使敌人的<color=#80FFD7FF>风元素抗性</color>与物理抗性降低12%，持续10秒。\\n被<color=#FFD780FF>高天之歌</color>击飞的敌人在落地前，<color=#80FFD7FF>风元素抗性</color>与物理抗性额外降低12%。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 223,
//            "name": "千风的诗篇",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Venti_02.png",
//            "effect": "<color=#FFD780FF>风神之诗</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 224,
//            "name": "自由的凛风",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Venti_03.png",
//            "effect": "温迪获取元素晶球或元素微粒后，获得25%<color=#80FFD7FF>风元素伤害加成</color>，持续10秒。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 225,
//            "name": "高天的协奏",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Venti_01.png",
//            "effect": "<color=#FFD780FF>高天之歌</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 226,
//            "name": "抗争的暴风",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Venti_04.png",
//            "effect": "受<color=#FFD780FF>风神之诗</color>伤害的敌人，<color=#80FFD7FF>风元素抗性</color>降低20%；\\n若产生了元素转化，则使转换的元素抗性也降低20%。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 0,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000037,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Ganyu@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Ganyu.png",
//        "name": "甘雨",
//        "element": "Cryo",
//        "fetter": 4,
//        "level": 80,
//        "rarity": 5,
//        "weapon": {
//          "id": 15406,
//          "name": "试作澹月",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Bow_Proto.png",
//          "type": 12,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "弓",
//          "desc": "黑岩厂中秘藏的原型长弓。放矢之姿有如透过薄暮的月光。",
//          "affix_level": 3
//        },
//        "reliquaries": [
//          {
//            "id": 75543,
//            "name": "角斗士的留恋",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15001_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150011,
//              "name": "角斗士的终幕礼",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为单手剑、双手剑、长柄武器角色时，角色普通攻击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 77524,
//            "name": "琴师的箭羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 77554,
//            "name": "终幕的时计",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 77514,
//            "name": "吟游者之壶",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 77534,
//            "name": "指挥的礼帽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 371,
//            "name": "饮露",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ganyu_01.png",
//            "effect": "二段蓄力重击的霜华矢或霜华绽发命中敌人时，会使敌人的<color=#99FFFFFF>冰元素抗性</color>降低15%，持续6秒；\\n此外，命中时会为甘雨恢复2点元素能量。每次二段蓄力重击只能触发一次元素能量恢复效果，无论霜华矢或霜华绽发是否都命中目标。",
//            "is_actived": false,
//            "pos": 1
//          },
//          {
//            "id": 372,
//            "name": "获麟",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ganyu_02.png",
//            "effect": "<color=#FFD780FF>山泽麟迹</color>的可使用次数增加1次。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 373,
//            "name": "云行",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ganyu_01.png",
//            "effect": "<color=#FFD780FF>降众天华</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 374,
//            "name": "西狩",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ganyu_03.png",
//            "effect": "在<color=#FFD780FF>降众天华</color>的领域内，敌人受到的伤害会增加，这个效果会随时间逐步加强。\\n受伤害加成初始为5%，每3秒提升5%，至多提升至25%。\\n离开领域后，效果至多持续3秒。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 375,
//            "name": "折草",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ganyu_02.png",
//            "effect": "<color=#FFD780FF>山泽麟迹</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 376,
//            "name": "履虫",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ganyu_04.png",
//            "effect": "施放<color=#FFD780FF>山泽麟迹</color>后30秒内的第一次霜华矢，无需蓄力即可施放。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 0,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000041,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Mona@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Mona.png",
//        "name": "莫娜",
//        "element": "Hydro",
//        "fetter": 2,
//        "level": 80,
//        "rarity": 5,
//        "weapon": {
//          "id": 14415,
//          "name": "证誓之明瞳",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Catalyst_Jyanome.png",
//          "type": 10,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "法器",
//          "desc": "大日御舆收藏的白夜国之宝。蛇神到来后，渊下宫用以公证大誓与大愿的宝物。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 77544,
//            "name": "乐团的晨光",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 77523,
//            "name": "琴师的箭羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 12,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 77553,
//            "name": "终幕的时计",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 75513,
//            "name": "角斗士的酣醉",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15001_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150011,
//              "name": "角斗士的终幕礼",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为单手剑、双手剑、长柄武器角色时，角色普通攻击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 77533,
//            "name": "指挥的礼帽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 411,
//            "name": "沉没的预言",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Mona_01.png",
//            "effect": "队伍中自己的角色攻击命中处于星异状态下的敌人后的8秒内，<color=#80C0FFFF>水元素相关反应</color>的效果提升：\\n·感电反应造成的伤害提升15%，蒸发反应造成的伤害提升15%，水元素扩散反应造成的伤害提升15%；\\n·冻结反应的持续时间延长15%。",
//            "is_actived": false,
//            "pos": 1
//          },
//          {
//            "id": 412,
//            "name": "星月的连珠",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Mona_02.png",
//            "effect": "普通攻击命中时，有20%的几率自动施放一次重击。\\n该效果每5秒只能触发一次。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 413,
//            "name": "不休的天象",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Mona_01.png",
//            "effect": "<color=#FFD780FF>星命定轨</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 414,
//            "name": "灭绝的预言",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Mona_03.png",
//            "effect": "队伍中所有角色攻击处于星异状态下的敌人时，暴击率提升15%。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 415,
//            "name": "命运的嘲弄",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Mona_02.png",
//            "effect": "<color=#FFD780FF>水中幻愿</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 416,
//            "name": "厄运的修辞",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Mona_04.png",
//            "effect": "进入<color=#FFD780FF>虚实流动</color>状态后，每移动1秒，莫娜的下一次重击伤害就增加60%，\\n通过这种方式至多可以获得180%重击伤害加成，该效果至多持续8秒。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 0,
//        "costumes": [
//          {
//            "id": 204101,
//            "name": "星与月之约",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/costume/UI_AvatarIcon_MonaCostumeWic@2x.png"
//          }
//        ],
//        "external": null
//      },
//      {
//        "id": 10000066,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Ayato@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Ayato.png",
//        "name": "神里绫人",
//        "element": "Hydro",
//        "fetter": 2,
//        "level": 80,
//        "rarity": 5,
//        "weapon": {
//          "id": 11409,
//          "name": "黑剑",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Sword_Bloodstained.png",
//          "type": 1,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "单手剑",
//          "desc": "渴求着纷争与砍杀的漆黑长剑，据说会让人沉醉在浴血厮杀的亢奋中。",
//          "affix_level": 3
//        },
//        "reliquaries": [
//          {
//            "id": 98543,
//            "name": "魂香之花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15024_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150241,
//              "name": "来歆余响",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "普通攻击命中敌人时，有36%概率触发「幽谷祝祀」：普通攻击造成的伤害提高，伤害提高值为攻击力的70%，该效果将在普通攻击造成伤害后的0.05秒后清除。普通攻击未触发「幽谷祝祀」时，会使下次触发概率提升20%；0.2秒内至多判定1次触发与否。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 98523,
//            "name": "垂玉之叶",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15024_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150241,
//              "name": "来歆余响",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "普通攻击命中敌人时，有36%概率触发「幽谷祝祀」：普通攻击造成的伤害提高，伤害提高值为攻击力的70%，该效果将在普通攻击造成伤害后的0.05秒后清除。普通攻击未触发「幽谷祝祀」时，会使下次触发概率提升20%；0.2秒内至多判定1次触发与否。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 98554,
//            "name": "祝祀之凭",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15024_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150241,
//              "name": "来歆余响",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "普通攻击命中敌人时，有36%概率触发「幽谷祝祀」：普通攻击造成的伤害提高，伤害提高值为攻击力的70%，该效果将在普通攻击造成伤害后的0.05秒后清除。普通攻击未触发「幽谷祝祀」时，会使下次触发概率提升20%；0.2秒内至多判定1次触发与否。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 55413,
//            "name": "战狂的骨杯",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_1.png",
//            "pos": 4,
//            "rarity": 4,
//            "level": 16,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 98534,
//            "name": "浮溯之珏",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15024_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 20,
//            "set": {
//              "id": 2150241,
//              "name": "来歆余响",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "普通攻击命中敌人时，有36%概率触发「幽谷祝祀」：普通攻击造成的伤害提高，伤害提高值为攻击力的70%，该效果将在普通攻击造成伤害后的0.05秒后清除。普通攻击未触发「幽谷祝祀」时，会使下次触发概率提升20%；0.2秒内至多判定1次触发与否。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 661,
//            "name": "镜华风姿",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayato_01.png",
//            "effect": "对于生命值低于或等于50%的敌人，<color=#FFD780FF>瞬水剑</color>造成的伤害提升40%。",
//            "is_actived": false,
//            "pos": 1
//          },
//          {
//            "id": 662,
//            "name": "世有源泉",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayato_02.png",
//            "effect": "<color=#FFD780FF>浪闪</color>叠加上限提升至5层；神里绫人处于至少3层浪闪状态下时，将提升50%生命值上限。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 663,
//            "name": "无意弄花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ayato_02.png",
//            "effect": "<color=#FFD780FF>神里流·镜花</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 664,
//            "name": "不厌细流",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayato_03.png",
//            "effect": "施放<color=#FFD780FF>神里流·水囿</color>后，队伍中附近的角色普通攻击的攻击速度提升15%，持续15秒。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 665,
//            "name": "万水一露",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ayato_01.png",
//            "effect": "<color=#FFD780FF>神里流·水囿</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 666,
//            "name": "滥觞无底",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayato_04.png",
//            "effect": "施放<color=#FFD780FF>神里流·镜花</color>之后，神里绫人的下一次瞬水剑攻击命中敌人时，将进行2次额外的瞬水剑攻击，各自能造成神里绫人攻击力450%的伤害。\\n此两次瞬水剑攻击不会受到浪闪的增益。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 0,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000053,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Sayu@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Sayu.png",
//        "name": "早柚",
//        "element": "Anemo",
//        "fetter": 9,
//        "level": 79,
//        "rarity": 4,
//        "weapon": {
//          "id": 12412,
//          "name": "衔珠海皇",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Claymore_MillenniaTuna.png",
//          "type": 11,
//          "rarity": 4,
//          "level": 90,
//          "promote_level": 6,
//          "type_name": "双手剑",
//          "desc": "海中的大王。经过风干，是称手的兵器以及应急食品。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 74442,
//            "name": "远方的少女之心",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14004_4.png",
//            "pos": 1,
//            "rarity": 4,
//            "level": 16,
//            "set": {
//              "id": 2140041,
//              "name": "被怜爱的少女",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "角色造成的治疗效果提升15%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技或元素爆发后的10秒内，队伍中所有角色受治疗效果加成提高20%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 57422,
//            "name": "教官的羽饰",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10007_2.png",
//            "pos": 2,
//            "rarity": 4,
//            "level": 12,
//            "set": {
//              "id": 2100071,
//              "name": "教官",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "触发元素反应后，队伍中所有角色的元素精通提高120点，持续8秒。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 74452,
//            "name": "少女苦短的良辰",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14004_5.png",
//            "pos": 3,
//            "rarity": 4,
//            "level": 4,
//            "set": {
//              "id": 2140041,
//              "name": "被怜爱的少女",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "角色造成的治疗效果提升15%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技或元素爆发后的10秒内，队伍中所有角色受治疗效果加成提高20%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 74513,
//            "name": "少女片刻的闲暇",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14004_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 4,
//            "set": {
//              "id": 2140041,
//              "name": "被怜爱的少女",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "角色造成的治疗效果提升15%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技或元素爆发后的10秒内，队伍中所有角色受治疗效果加成提高20%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 59433,
//            "name": "流放者头冠",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10009_3.png",
//            "pos": 5,
//            "rarity": 4,
//            "level": 16,
//            "set": {
//              "id": 2100091,
//              "name": "流放者",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，每2秒为队伍中所有角色（不包括自己）恢复2点元素能量。该效果持续6秒，无法叠加。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 531,
//            "name": "一心二用之术",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sayu_01.png",
//            "effect": "<color=#FFD780FF>呜呼流·影貉缭乱</color>的不倒貉貉的行动将忽视生命值限制，能同时攻击附近的敌人并为角色恢复生命值。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 532,
//            "name": "理清逃跑路线",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sayu_02.png",
//            "effect": "<color=#FFD780FF>呜呼流·风隐急进</color>获得如下效果：\\n·点按施放时，风风轮舞踢造成的伤害提高3.3%；\\n·处于长按施放后的风风轮状态下时，每0.5秒，就会使这次施展的风风轮舞踢造成的伤害提高3.3%。通过这种方式，风风轮舞踢造成的伤害至多可以提高66%。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 533,
//            "name": "都交给分身吧",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Sayu_02.png",
//            "effect": "<color=#FFD780FF>呜呼流·影貉缭乱</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 534,
//            "name": "偷懒的新方法",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sayu_03.png",
//            "effect": "早柚在场上触发扩散反应时，将恢复1.2点元素能量。\\n该效果每2秒只能触发一次。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 535,
//            "name": "快是第一奥义",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Sayu_01.png",
//            "effect": "<color=#FFD780FF>呜呼流·风隐急进</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 536,
//            "name": "呼呼大睡时间",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sayu_04.png",
//            "effect": "早柚自己通过<color=#FFD780FF>呜呼流·影貉缭乱</color>召唤的不倒貉貉的攻击与回复量，受益于早柚的元素精通。早柚的每点元素精通，能产生如下效果：\\n·使不倒貉貉的攻击额外造成0.2%攻击力的伤害。通过这种方式至多额外造成400%攻击力的伤害；\\n·使不倒貉貉的回复量提高3点。通过这种方式，至多提高6000点回复量。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 4,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000056,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Sara@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Sara.png",
//        "name": "九条裟罗",
//        "element": "Electro",
//        "fetter": 9,
//        "level": 79,
//        "rarity": 4,
//        "weapon": {
//          "id": 15401,
//          "name": "西风猎弓",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Bow_Zephyrus.png",
//          "type": 12,
//          "rarity": 4,
//          "level": 50,
//          "promote_level": 2,
//          "type_name": "弓",
//          "desc": "西风骑士团的制式反曲弓，只有杰出的弓手能与它的杰出性能相衬。",
//          "affix_level": 1
//        },
//        "reliquaries": [
//          {
//            "id": 75543,
//            "name": "角斗士的留恋",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15001_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150011,
//              "name": "角斗士的终幕礼",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为单手剑、双手剑、长柄武器角色时，角色普通攻击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 75523,
//            "name": "角斗士的归宿",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15001_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150011,
//              "name": "角斗士的终幕礼",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为单手剑、双手剑、长柄武器角色时，角色普通攻击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 90553,
//            "name": "坚铜罗盘",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15016_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150161,
//              "name": "沉沦之心",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%水元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技后的15秒内，普通攻击与重击造成的伤害提高30%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 75513,
//            "name": "角斗士的酣醉",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15001_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150011,
//              "name": "角斗士的终幕礼",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为单手剑、双手剑、长柄武器角色时，角色普通攻击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 75534,
//            "name": "角斗士的凯旋",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15001_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150011,
//              "name": "角斗士的终幕礼",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为单手剑、双手剑、长柄武器角色时，角色普通攻击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 561,
//            "name": "乌眼",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sara_05.png",
//            "effect": "天狗咒雷为角色施加攻击力提升效果或命中敌人后，<color=#FFD780FF>鸦羽天狗霆雷召咒</color>的冷却时间减少1秒。\\n该效果每3秒至多触发一次。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 562,
//            "name": "鸦羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sara_02.png",
//            "effect": "施放<color=#FFD780FF>鸦羽天狗霆雷召咒</color>时，会在九条裟罗原本的位置留下能引发一次较弱的天狗咒雷·伏的「乌羽」，造成原本30%的伤害。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 563,
//            "name": "心魔",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Sara_02.png",
//            "effect": "<color=#FFD780FF>煌煌千道镇式</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 564,
//            "name": "彻证",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sara_03.png",
//            "effect": "<color=#FFD780FF>煌煌千道镇式</color>释放的天狗咒雷·雷砾增加至6道。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 565,
//            "name": "咒咏",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Sara_01.png",
//            "effect": "<color=#FFD780FF>鸦羽天狗霆雷召咒</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 566,
//            "name": "我界",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sara_04.png",
//            "effect": "处于天狗咒雷带来的攻击力提升效果状态下的角色，其<color=#FFACFFFF>雷元素伤害</color>的暴击伤害提高60%。",
//            "is_actived": true,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 6,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000043,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Sucrose@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Sucrose.png",
//        "name": "砂糖",
//        "element": "Anemo",
//        "fetter": 3,
//        "level": 79,
//        "rarity": 4,
//        "weapon": {
//          "id": 14403,
//          "name": "祭礼残章",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Catalyst_Fossil.png",
//          "type": 10,
//          "rarity": 4,
//          "level": 40,
//          "promote_level": 1,
//          "type_name": "法器",
//          "desc": "经历漫长岁月的剧本，记载着的颂词和剧本已经无法辨认。被下了受时间之风侵蚀毁坏的诅咒。",
//          "affix_level": 3
//        },
//        "reliquaries": [
//          {
//            "id": 76543,
//            "name": "野花记忆的绿野",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15002_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 8,
//            "set": {
//              "id": 2150021,
//              "name": "翠绿之影",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%风元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "扩散反应造成的伤害提升60%。根据扩散的元素类型，降低受到影响的敌人40%的对应元素抗性，持续10秒。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 76523,
//            "name": "猎人青翠的箭羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15002_2.png",
//            "pos": 2,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150021,
//              "name": "翠绿之影",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%风元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "扩散反应造成的伤害提升60%。根据扩散的元素类型，降低受到影响的敌人40%的对应元素抗性，持续10秒。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 76554,
//            "name": "翠绿猎人的笃定",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15002_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 8,
//            "set": {
//              "id": 2150021,
//              "name": "翠绿之影",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%风元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "扩散反应造成的伤害提升60%。根据扩散的元素类型，降低受到影响的敌人40%的对应元素抗性，持续10秒。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 76513,
//            "name": "翠绿猎人的容器",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15002_1.png",
//            "pos": 4,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150021,
//              "name": "翠绿之影",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%风元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "扩散反应造成的伤害提升60%。根据扩散的元素类型，降低受到影响的敌人40%的对应元素抗性，持续10秒。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 76534,
//            "name": "翠绿的猎人之冠",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15002_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 0,
//            "set": {
//              "id": 2150021,
//              "name": "翠绿之影",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "获得15%风元素伤害加成。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "扩散反应造成的伤害提升60%。根据扩散的元素类型，降低受到影响的敌人40%的对应元素抗性，持续10秒。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 431,
//            "name": "堆叠真空域",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sucrose_01.png",
//            "effect": "<color=#FFD780FF>风灵作成·陆叁零捌</color>的可使用次数增加1次。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 432,
//            "name": "不羁型贝特",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sucrose_02.png",
//            "effect": "<color=#FFD780FF>禁·风灵作成·柒伍同构贰型</color>的技能持续时间延长2秒。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 433,
//            "name": "零失误少女",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Sucrose_01.png",
//            "effect": "<color=#FFD780FF>风灵作成·陆叁零捌</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 434,
//            "name": "炼金的偏执",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sucrose_03.png",
//            "effect": "砂糖的普通攻击或者重击累计命中敌人7次，<color=#FFD780FF>风灵作成·陆叁零捌</color>的冷却时间就会随机减少1-7秒。\\n每0.1秒至多计数一次。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 435,
//            "name": "认真普通瓶",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Sucrose_02.png",
//            "effect": "<color=#FFD780FF>禁·风灵作成·柒伍同构贰型</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 436,
//            "name": "混元熵增论",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Sucrose_04.png",
//            "effect": "<color=#FFD780FF>禁·风灵作成·柒伍同构贰型</color>如果发生了元素转化，则使队伍中所有角色在技能持续时间内获得20%的对应元素伤害加成。",
//            "is_actived": true,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 6,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000007,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_PlayerGirl@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_PlayerGirl.png",
//        "name": "旅行者",
//        "element": "Geo",
//        "fetter": 0,
//        "level": 70,
//        "rarity": 5,
//        "weapon": {
//          "id": 11406,
//          "name": "试作斩岩",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Sword_Proto.png",
//          "type": 1,
//          "rarity": 4,
//          "level": 40,
//          "promote_level": 1,
//          "type_name": "单手剑",
//          "desc": "黑岩厂中秘藏的古老长剑。可挥砍断岩而刃不卷。",
//          "affix_level": 1
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 91,
//            "name": "巍然的青岩",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_PlayerRock_01.png",
//            "effect": "队伍中角色处于<color=#FFD780FF>岩潮叠嶂</color>的岩嶂包围中时，暴击率提升10%，并提高抗打断能力。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 92,
//            "name": "不稳的熔岩",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_PlayerRock_02.png",
//            "effect": "<color=#FFD780FF>星陨剑</color>的荒星被摧毁时会再度发生爆炸，造成等同于星陨剑伤害的额外<color=#FFE699FF>岩元素范围伤害</color>。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 93,
//            "name": "八方之岩",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_PlayerRock_02.png",
//            "effect": "<color=#FFD780FF>岩潮叠嶂</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 94,
//            "name": "险峻的重岩",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_PlayerRock_03.png",
//            "effect": "<color=#FFD780FF>岩潮叠嶂</color>引发的震荡波每击中一个敌人，都会恢复5点元素能量。\\n通过这种方式，一次至多恢复25点元素能量。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 95,
//            "name": "天坠之岩",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_PlayerRock_01.png",
//            "effect": "<color=#FFD780FF>星陨剑</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 96,
//            "name": "永世的磐岩",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_PlayerRock_04.png",
//            "effect": "<color=#FFD780FF>岩潮叠嶂</color>的岩嶂持续时间延长5秒；\\n<color=#FFD780FF>星陨剑</color>的荒星持续时间延长10秒。",
//            "is_actived": true,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 6,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000036,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Chongyun@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Chongyun.png",
//        "name": "重云",
//        "element": "Cryo",
//        "fetter": 5,
//        "level": 60,
//        "rarity": 4,
//        "weapon": {
//          "id": 12401,
//          "name": "西风大剑",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Claymore_Zephyrus.png",
//          "type": 11,
//          "rarity": 4,
//          "level": 40,
//          "promote_level": 2,
//          "type_name": "双手剑",
//          "desc": "西风骑士团的重型仪式剑。能轻易导出元素力量，具有卓越的破坏力。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 55442,
//            "name": "战狂的蔷薇",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_4.png",
//            "pos": 1,
//            "rarity": 4,
//            "level": 4,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 55422,
//            "name": "战狂的翎羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_2.png",
//            "pos": 2,
//            "rarity": 4,
//            "level": 8,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 75452,
//            "name": "角斗士的希冀",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15001_5.png",
//            "pos": 3,
//            "rarity": 4,
//            "level": 4,
//            "set": {
//              "id": 2150011,
//              "name": "角斗士的终幕礼",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为单手剑、双手剑、长柄武器角色时，角色普通攻击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 57412,
//            "name": "教官的茶杯",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10007_1.png",
//            "pos": 4,
//            "rarity": 4,
//            "level": 4,
//            "set": {
//              "id": 2100071,
//              "name": "教官",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "触发元素反应后，队伍中所有角色的元素精通提高120点，持续8秒。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 87433,
//            "name": "祭冰礼冠",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15013_3.png",
//            "pos": 5,
//            "rarity": 4,
//            "level": 4,
//            "set": {
//              "id": 2150130,
//              "name": "祭冰之人",
//              "affixes": [
//                {
//                  "activation_number": 1,
//                  "effect": "受到的冰元素附着效果的持续时间减少40%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 361,
//            "name": "释凌咏冰",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Chongyun_01.png",
//            "effect": "普通攻击的最后一击会向前方释放三道冰之刃，每道冰之刃对沿途的敌人造成重云50%攻击力的<color=#99FFFFFF>冰元素伤害</color>。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 362,
//            "name": "周天运转",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Chongyun_02.png",
//            "effect": "在<color=#FFD780FF>灵刃·重华叠霜</color>领域内施放的元素战技与元素爆发的冷却时间减少15%。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 363,
//            "name": "云尽光生",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Chongyun_01.png",
//            "effect": "<color=#FFD780FF>灵刃·云开星落</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 364,
//            "name": "浮云霜天",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Chongyun_03.png",
//            "effect": "重云的所有攻击命中受到<color=#99FFFFFF>冰元素</color>影响的敌人时，自身将恢复1点元素能量。\\n该效果每2秒最多触发一次。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 365,
//            "name": "真道正理",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Chongyun_02.png",
//            "effect": "<color=#FFD780FF>灵刃·重华叠霜</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 366,
//            "name": "四灵捧圣",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Chongyun_04.png",
//            "effect": "<color=#FFD780FF>灵刃·云开星落</color>对生命值百分比低于重云的敌人造成伤害时，伤害提升15%；\\n此外，施放时，会召唤一柄额外的灵刃。",
//            "is_actived": true,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 6,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000064,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Yunjin@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Yunjin.png",
//        "name": "云堇",
//        "element": "Geo",
//        "fetter": 1,
//        "level": 59,
//        "rarity": 4,
//        "weapon": {
//          "id": 13407,
//          "name": "西风长枪",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Pole_Zephyrus.png",
//          "type": 13,
//          "rarity": 4,
//          "level": 70,
//          "promote_level": 4,
//          "type_name": "长柄武器",
//          "desc": "西风骑士团的制式长枪。枪杆直挺，枪尖轻风流溢。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 77543,
//            "name": "乐团的晨光",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_4.png",
//            "pos": 1,
//            "rarity": 5,
//            "level": 12,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 55422,
//            "name": "战狂的翎羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_2.png",
//            "pos": 2,
//            "rarity": 4,
//            "level": 16,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 73554,
//            "name": "渡火者的煎熬",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14003_5.png",
//            "pos": 3,
//            "rarity": 5,
//            "level": 16,
//            "set": {
//              "id": 2140031,
//              "name": "渡过烈火的贤人",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "火元素抗性提高40%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "对处于火元素影响下的敌人造成的伤害提升35%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 55412,
//            "name": "战狂的骨杯",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_1.png",
//            "pos": 4,
//            "rarity": 4,
//            "level": 6,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 93533,
//            "name": "无常之面",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15019_3.png",
//            "pos": 5,
//            "rarity": 5,
//            "level": 16,
//            "set": {
//              "id": 2150191,
//              "name": "追忆之注连",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "攻击力提高18%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技时，如果角色的元素能量高于或等于15点，则会流失15点元素能量，使接下来的10秒内，普通攻击、重击、下落攻击造成的伤害提高50%，持续期间内该效果不会再次触发。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 641,
//            "name": "飞身趟马",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yunjin_01.png",
//            "effect": "<color=#FFD780FF>旋云开相</color>的冷却时间减少18%。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 642,
//            "name": "诸般切末",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yunjin_02.png",
//            "effect": "施放<color=#FFD780FF>破嶂见旌仪</color>后，附近队伍中所有角色普通攻击造成的伤害提升15%，持续12秒。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 643,
//            "name": "牙纛探海",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Yunjin_01.png",
//            "effect": "<color=#FFD780FF>破嶂见旌仪</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 644,
//            "name": "昇堂吊云",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yunjin_03.png",
//            "effect": "云堇触发结晶反应后，防御力提升20%，持续12秒。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 645,
//            "name": "翘楚名坤",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Yunjin_02.png",
//            "effect": "<color=#FFD780FF>旋云开相</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 646,
//            "name": "庄谐并举",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Yunjin_04.png",
//            "effect": "处于<color=#FFD780FF>「飞云旗阵」</color>状态下的角色，普通攻击的攻击速度提升12%。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 2,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000014,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Barbara@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Barbara.png",
//        "name": "芭芭拉",
//        "element": "Hydro",
//        "fetter": 10,
//        "level": 50,
//        "rarity": 4,
//        "weapon": {
//          "id": 14302,
//          "name": "讨龙英杰谭",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Catalyst_Pulpfic.png",
//          "type": 10,
//          "rarity": 3,
//          "level": 50,
//          "promote_level": 3,
//          "type_name": "法器",
//          "desc": "五名英雄踏上屠龙征途的虚构故事。文笔很差，结构散乱。失败的教训是这本书所拥有的伟大力量。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 55442,
//            "name": "战狂的蔷薇",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_4.png",
//            "pos": 1,
//            "rarity": 4,
//            "level": 16,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 56423,
//            "name": "武人的羽饰",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10006_2.png",
//            "pos": 2,
//            "rarity": 4,
//            "level": 0,
//            "set": {
//              "id": 2100061,
//              "name": "武人",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "普通攻击与重击造成的伤害提高15%；"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技后的8秒内，普通攻击和重击造成的伤害提升25%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 77452,
//            "name": "终幕的时计",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15003_5.png",
//            "pos": 3,
//            "rarity": 4,
//            "level": 0,
//            "set": {
//              "id": 2150031,
//              "name": "流浪大地的乐团",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素精通提高80点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "装备该圣遗物套装的角色为法器、弓箭角色时，角色重击造成的伤害提高35%。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 56412,
//            "name": "武人的酒杯",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10006_1.png",
//            "pos": 4,
//            "rarity": 4,
//            "level": 0,
//            "set": {
//              "id": 2100061,
//              "name": "武人",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "普通攻击与重击造成的伤害提高15%；"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素战技后的8秒内，普通攻击和重击造成的伤害提升25%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 55432,
//            "name": "战狂的鬼面",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_3.png",
//            "pos": 5,
//            "rarity": 4,
//            "level": 0,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 141,
//            "name": "彩色歌谣",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Barbara_01.png",
//            "effect": "芭芭拉每10秒恢复1点元素能量。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 142,
//            "name": "元气迸发",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Barbara_02.png",
//            "effect": "<color=#FFD780FF>演唱，开始♪</color>的冷却时间降低15%；\\n技能持续期间，当前场上自己的角色获得15%<color=#80C0FFFF>水元素伤害加成</color>。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 143,
//            "name": "明日之星",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Barbara_02.png",
//            "effect": "<color=#FFD780FF>闪耀奇迹♪</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 144,
//            "name": "努力即魔法",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Barbara_03.png",
//            "effect": "芭芭拉使用重击时，每命中一个敌人，就恢复1点元素能量。\\n通过这种方式，一次至多回复5点元素能量。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 145,
//            "name": "纯真的羁绊",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Barbara_01.png",
//            "effect": "<color=#FFD780FF>演唱，开始♪</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 146,
//            "name": "将一切美好献给你",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Barbara_04.png",
//            "effect": "芭芭拉处于队伍后台时，队伍中自己的角色倒下时，则立即：\\n·复苏该角色；\\n·将该角色生命值恢复至100%。\\n该效果每15分钟只能触发一次。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 3,
//        "costumes": [
//          {
//            "id": 201401,
//            "name": "闪耀协奏",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/costume/UI_AvatarIcon_BarbaraCostumeSummertime@2x.png"
//          }
//        ],
//        "external": null
//      },
//      {
//        "id": 10000027,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Ningguang@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Ningguang.png",
//        "name": "凝光",
//        "element": "Geo",
//        "fetter": 10,
//        "level": 50,
//        "rarity": 4,
//        "weapon": {
//          "id": 14401,
//          "name": "西风秘典",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Catalyst_Zephyrus.png",
//          "type": 10,
//          "rarity": 4,
//          "level": 40,
//          "promote_level": 1,
//          "type_name": "法器",
//          "desc": "西风骑士团的学者间流传的秘典，记载着元素与物质的道理和力量。",
//          "affix_level": 5
//        },
//        "reliquaries": [
//          {
//            "id": 55442,
//            "name": "战狂的蔷薇",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_4.png",
//            "pos": 1,
//            "rarity": 4,
//            "level": 4,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 62422,
//            "name": "学士的羽笔",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10012_2.png",
//            "pos": 2,
//            "rarity": 4,
//            "level": 4,
//            "set": {
//              "id": 2100121,
//              "name": "学士",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "获得元素微粒或元素晶球时，队伍中所有弓箭和法器角色额外恢复3点元素能量。该效果每3秒只能触发一次。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 62352,
//            "name": "学士的时钟",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10012_5.png",
//            "pos": 3,
//            "rarity": 3,
//            "level": 0,
//            "set": {
//              "id": 2100121,
//              "name": "学士",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "获得元素微粒或元素晶球时，队伍中所有弓箭和法器角色额外恢复3点元素能量。该效果每3秒只能触发一次。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 55312,
//            "name": "战狂的骨杯",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_1.png",
//            "pos": 4,
//            "rarity": 3,
//            "level": 0,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 55332,
//            "name": "战狂的鬼面",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_3.png",
//            "pos": 5,
//            "rarity": 3,
//            "level": 0,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 271,
//            "name": "悬星尽散击云碎",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ningguang_01.png",
//            "effect": "普通攻击命中时，会造成范围伤害。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 272,
//            "name": "璇玑合璧镇昆仑",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ningguang_05.png",
//            "effect": "<color=#FFD780FF>璇玑屏</color>碎裂时，会清除冷却时间。\\n该效果每6秒只能触发一次。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 273,
//            "name": "星罗宿列天权临",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ningguang_02.png",
//            "effect": "<color=#FFD780FF>天权崩玉</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 274,
//            "name": "攻守易形著神机",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ningguang_03.png",
//            "effect": "<color=#FFD780FF>璇玑屏</color>会使周围角色的所有元素抗性提升10%。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 275,
//            "name": "琼屏千扇正天衡",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ningguang_01.png",
//            "effect": "<color=#FFD780FF>璇玑屏</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 276,
//            "name": "七星璨璨凝流光",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ningguang_04.png",
//            "effect": "施放<color=#FFD780FF>天权崩玉</color>时，会为凝光生成七枚星璇。",
//            "is_actived": true,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 6,
//        "costumes": [
//          {
//            "id": 202701,
//            "name": "纱中幽兰",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/costume/UI_AvatarIcon_NingguangCostumeFloral@2x.png"
//          }
//        ],
//        "external": null
//      },
//      {
//        "id": 10000016,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Diluc@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Diluc.png",
//        "name": "迪卢克",
//        "element": "Pyro",
//        "fetter": 3,
//        "level": 50,
//        "rarity": 5,
//        "weapon": {
//          "id": 12403,
//          "name": "祭礼大剑",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Claymore_Fossil.png",
//          "type": 11,
//          "rarity": 4,
//          "level": 60,
//          "promote_level": 3,
//          "type_name": "双手剑",
//          "desc": "在漫长岁月中石化的道具大剑，上面的仪式性装饰依然清晰可见。拥有受时间之风冲刷的祝福力量。",
//          "affix_level": 5
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 161,
//            "name": "罪罚裁断",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Diluc_01.png",
//            "effect": "对生命值高于50%的敌人，迪卢克造成的伤害提高15%。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 162,
//            "name": "炙热余烬",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Diluc_02.png",
//            "effect": "迪卢克受到伤害时，攻击力提高10%，攻击速度提高5%，持续10秒。\\n该效果至多叠加3次，每1.5秒只能触发一次。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 163,
//            "name": "钢铁炽焰",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Diluc_01.png",
//            "effect": "<color=#FFD780FF>逆焰之刃</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 164,
//            "name": "流火焦灼",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Diluc_03.png",
//            "effect": "有节奏地释放<color=#FFD780FF>逆焰之刃</color>可以大幅提升造成的伤害。\\n施放<color=#FFD780FF>逆焰之刃</color>的2秒后，使下一段逆焰之刃的伤害提高40%，持续2秒。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 165,
//            "name": "昭告黎明的火之鸟",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Diluc_02.png",
//            "effect": "<color=#FFD780FF>黎明</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 166,
//            "name": "清算黑暗的炎之剑",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Diluc_04.png",
//            "effect": "施放<color=#FFD780FF>逆焰之刃</color>后，接下来6秒内的2次普通攻击速度提升30%，造成的伤害提高30%。\\n此外，逆焰之刃不再重置普通攻击连击段数。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 2,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000024,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Beidou@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Beidou.png",
//        "name": "北斗",
//        "element": "Electro",
//        "fetter": 9,
//        "level": 40,
//        "rarity": 4,
//        "weapon": {
//          "id": 12406,
//          "name": "试作古华",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Claymore_Proto.png",
//          "type": 11,
//          "rarity": 4,
//          "level": 1,
//          "promote_level": 0,
//          "type_name": "双手剑",
//          "desc": "黑岩厂中秘藏的古老大刀。挥舞时，仿佛连空间本身也要被一刀两断。",
//          "affix_level": 1
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 241,
//            "name": "鱼龙沉四方",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Beidou_02.png",
//            "effect": "施放<color=#FFD780FF>斫雷</color>时：\\n生成一个伤害吸收量等于生命值上限16%的护盾，持续15秒。\\n该护盾对<color=#FFACFFFF>雷元素伤害</color>有250%的吸收效果。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 242,
//            "name": "赫赫雷涌起",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Beidou_01.png",
//            "effect": "<color=#FFD780FF>斫雷</color>的闪雷能额外弹跳2个敌人。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 243,
//            "name": "潮奔蓦引电",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Beidou_01.png",
//            "effect": "<color=#FFD780FF>捉浪</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 244,
//            "name": "牵星觅乡岸",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Beidou_03.png",
//            "effect": "受到攻击后的10秒内，北斗的普通攻击附带20%额外<color=#FFACFFFF>雷元素伤害</color>。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 245,
//            "name": "踏浪霞连阶",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Beidou_02.png",
//            "effect": "<color=#FFD780FF>斫雷</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 246,
//            "name": "北斗祓幽孽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Beidou_04.png",
//            "effect": "<color=#FFD780FF>斫雷</color>持续期间，周围敌人的<color=#FFACFFFF>雷元素抗性</color>降低15%。",
//            "is_actived": true,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 6,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000020,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Razor@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Razor.png",
//        "name": "雷泽",
//        "element": "Electro",
//        "fetter": 2,
//        "level": 40,
//        "rarity": 4,
//        "weapon": {
//          "id": 12402,
//          "name": "钟剑",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Claymore_Troupe.png",
//          "type": 11,
//          "rarity": 4,
//          "level": 1,
//          "promote_level": 0,
//          "type_name": "双手剑",
//          "desc": "装有时钟的厚重大剑，其中的计时机关早已被破坏。",
//          "affix_level": 2
//        },
//        "reliquaries": [
//          {
//            "id": 59342,
//            "name": "流放者之花",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10009_4.png",
//            "pos": 1,
//            "rarity": 3,
//            "level": 0,
//            "set": {
//              "id": 2100091,
//              "name": "流放者",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，每2秒为队伍中所有角色（不包括自己）恢复2点元素能量。该效果持续6秒，无法叠加。"
//                }
//              ]
//            },
//            "pos_name": "生之花"
//          },
//          {
//            "id": 55322,
//            "name": "战狂的翎羽",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10005_2.png",
//            "pos": 2,
//            "rarity": 3,
//            "level": 0,
//            "set": {
//              "id": 2100051,
//              "name": "战狂",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "暴击率提高12%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "生命值低于70%时，暴击率额外提升24%。"
//                }
//              ]
//            },
//            "pos_name": "死之羽"
//          },
//          {
//            "id": 59351,
//            "name": "流放者怀表",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10009_5.png",
//            "pos": 3,
//            "rarity": 3,
//            "level": 0,
//            "set": {
//              "id": 2100091,
//              "name": "流放者",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "元素充能效率提高20%。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "施放元素爆发后，每2秒为队伍中所有角色（不包括自己）恢复2点元素能量。该效果持续6秒，无法叠加。"
//                }
//              ]
//            },
//            "pos_name": "时之沙"
//          },
//          {
//            "id": 61312,
//            "name": "幸运儿之杯",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_10011_1.png",
//            "pos": 4,
//            "rarity": 3,
//            "level": 0,
//            "set": {
//              "id": 2100111,
//              "name": "幸运儿",
//              "affixes": [
//                {
//                  "activation_number": 2,
//                  "effect": "防御力提高100点。"
//                },
//                {
//                  "activation_number": 4,
//                  "effect": "拾取摩拉时，恢复300点生命值。"
//                }
//              ]
//            },
//            "pos_name": "空之杯"
//          },
//          {
//            "id": 87331,
//            "name": "祭冰礼冠",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15013_3.png",
//            "pos": 5,
//            "rarity": 3,
//            "level": 0,
//            "set": {
//              "id": 2150130,
//              "name": "祭冰之人",
//              "affixes": [
//                {
//                  "activation_number": 1,
//                  "effect": "受到的冰元素附着效果的持续时间减少40%。"
//                }
//              ]
//            },
//            "pos_name": "理之冠"
//          }
//        ],
//        "constellations": [
//          {
//            "id": 201,
//            "name": "狼性",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Razor_01.png",
//            "effect": "雷泽获取元素晶球或元素微粒后的8秒内，造成的伤害提高10%。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 202,
//            "name": "压制",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Razor_02.png",
//            "effect": "雷泽攻击生命值低于30%的敌人时，暴击率提高10%。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 203,
//            "name": "兽魂",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Razor_02.png",
//            "effect": "<color=#FFD780FF>雷牙</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 204,
//            "name": "撕咬",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Razor_03.png",
//            "effect": "<color=#FFD780FF>利爪与苍雷</color>点按时，会使命中的敌人防御力降低15%，持续7秒。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 205,
//            "name": "利爪",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Razor_01.png",
//            "effect": "<color=#FFD780FF>利爪与苍雷</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 206,
//            "name": "天狼",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Razor_04.png",
//            "effect": "每10秒，雷泽的大剑将自动充能，使下一次普通攻击引发落雷，造成100%攻击力的<color=#FFACFFFF>雷元素伤害</color>。\\n不处于<color=#FFD780FF>雷牙</color>状态下时，若落雷击中敌人，会为雷泽积攒一个<color=#FFD780FF>利爪与苍雷</color>的雷之印。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 2,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000006,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Lisa@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Lisa.png",
//        "name": "丽莎",
//        "element": "Electro",
//        "fetter": 7,
//        "level": 31,
//        "rarity": 4,
//        "weapon": {
//          "id": 14502,
//          "name": "四风原典",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Catalyst_Fourwinds.png",
//          "type": 10,
//          "rarity": 5,
//          "level": 1,
//          "promote_level": 0,
//          "type_name": "法器",
//          "desc": "崇信风的无名先民所写的教典珍本。数千年流传的信仰之力得到了风的青睐，饱含祝福与力量。",
//          "affix_level": 2
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 41,
//            "name": "无限的电回路",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Lisa_01.png",
//            "effect": "<color=#FFD780FF>苍雷</color>长按时，每个命中的敌人都会为丽莎恢复2点元素能量。\\n通过这种方式，一次至多回复10点元素能量。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 42,
//            "name": "空间电势结界",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Lisa_02.png",
//            "effect": "<color=#FFD780FF>苍雷</color>长按时，具有如下效果：\\n·防御力提升25%；\\n·提高丽莎的抗打断能力。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 43,
//            "name": "谐振的雷光",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Lisa_02.png",
//            "effect": "<color=#FFD780FF>蔷薇的雷光</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 44,
//            "name": "如雨的电浆",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Lisa_03.png",
//            "effect": "<color=#FFD780FF>蔷薇的雷光</color>攻击时，放出的闪电增加至1~3道。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 45,
//            "name": "等离态的落雷",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Lisa_01.png",
//            "effect": "<color=#FFD780FF>苍雷</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 46,
//            "name": "脉冲的魔女",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Lisa_04.png",
//            "effect": "丽莎登场时，对附近的敌人施加3层<color=#FFD780FF>苍雷</color>的引雷效果。\\n该效果每5秒只能触发一次。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 1,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000021,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Ambor@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Ambor.png",
//        "name": "安柏",
//        "element": "Pyro",
//        "fetter": 10,
//        "level": 25,
//        "rarity": 4,
//        "weapon": {
//          "id": 15101,
//          "name": "猎弓",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Bow_Hunters.png",
//          "type": 12,
//          "rarity": 1,
//          "level": 1,
//          "promote_level": 0,
//          "type_name": "弓",
//          "desc": "猎手演奏的音乐由两种音色组成。弓弦颤动的声音，和羽箭破空的低啸。",
//          "affix_level": 1
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 211,
//            "name": "一箭双丘丘！",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ambor_01.png",
//            "effect": "<color=#FFD780FF>瞄准射击</color>时，会连续射出2支箭。第二支箭能造成原本20%的伤害。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 212,
//            "name": "一触即发",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ambor_02.png",
//            "effect": "兔兔伯爵进行了全新改良！蓄力完成的瞄准射击命中兔兔伯爵脚部时，能直接引爆兔兔伯爵…\\n通过这种方式主动引爆兔兔伯爵时，会额外造成200%伤害。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 213,
//            "name": "烧起来啦！",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ambor_02.png",
//            "effect": "<color=#FFD780FF>箭雨</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 214,
//            "name": "才不是普通的布偶",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ambor_03.png",
//            "effect": "<color=#FFD780FF>爆弹玩偶</color>的冷却时间减少20%，并增加1次可使用次数。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 215,
//            "name": "是兔兔伯爵！",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ambor_01.png",
//            "effect": "<color=#FFD780FF>爆弹玩偶</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 216,
//            "name": "疾如野火",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ambor_04.png",
//            "effect": "使用<color=#FFD780FF>箭雨</color>后的10秒内，队伍中所有角色的移动速度提升15%，攻击力提升15%。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 1,
//        "costumes": [
//          {
//            "id": 202101,
//            "name": "100%侦察骑士",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/costume/UI_AvatarIcon_AmborCostumeWic@2x.png"
//          }
//        ],
//        "external": null
//      },
//      {
//        "id": 10000034,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Noel@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Noel.png",
//        "name": "诺艾尔",
//        "element": "Geo",
//        "fetter": 7,
//        "level": 20,
//        "rarity": 4,
//        "weapon": {
//          "id": 12401,
//          "name": "西风大剑",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Claymore_Zephyrus.png",
//          "type": 11,
//          "rarity": 4,
//          "level": 1,
//          "promote_level": 0,
//          "type_name": "双手剑",
//          "desc": "西风骑士团的重型仪式剑。能轻易导出元素力量，具有卓越的破坏力。",
//          "affix_level": 3
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 341,
//            "name": "支援就交给我吧",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Noel_01.png",
//            "effect": "同时处于<color=#FFD780FF>大扫除</color>与<color=#FFD780FF>护心铠</color>状态时，护心铠的生命值回复效果触发几率提升至100%。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 342,
//            "name": "旋风女仆",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Noel_02.png",
//            "effect": "诺艾尔的重击的体力消耗降低20%，伤害提升15%。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 343,
//            "name": "女仆不会受伤",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Noel_01.png",
//            "effect": "<color=#FFD780FF>护心铠</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 344,
//            "name": "之后会扫干净的",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Noel_03.png",
//            "effect": "<color=#FFD780FF>护心铠</color>在效果结束时，或因伤害破碎时，会对周围的敌人造成400%攻击力的<color=#FFE699FF>岩元素伤害</color>。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 345,
//            "name": "骑士团扫除专家",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Noel_02.png",
//            "effect": "<color=#FFD780FF>大扫除</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 346,
//            "name": "要一尘不染才行",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Noel_04.png",
//            "effect": "<color=#FFD780FF>大扫除</color>额外提高诺艾尔防御力50%的攻击力；\\n此外，在技能持续时间内，每打倒1个敌人，其持续时间将延长1秒，最多不会超过10秒。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 5,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000045,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Rosaria@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Rosaria.png",
//        "name": "罗莎莉亚",
//        "element": "Cryo",
//        "fetter": 7,
//        "level": 20,
//        "rarity": 4,
//        "weapon": {
//          "id": 13407,
//          "name": "西风长枪",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Pole_Zephyrus.png",
//          "type": 13,
//          "rarity": 4,
//          "level": 1,
//          "promote_level": 0,
//          "type_name": "长柄武器",
//          "desc": "西风骑士团的制式长枪。枪杆直挺，枪尖轻风流溢。",
//          "affix_level": 1
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 451,
//            "name": "罪之导引",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Rosaria_01.png",
//            "effect": "罗莎莉亚的攻击造成暴击后，自身攻击速度提升10%，普通攻击造成的伤害提升10%，持续4秒。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 452,
//            "name": "无福之地",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Rosaria_02.png",
//            "effect": "<color=#FFD780FF>终命的圣礼</color>创造的冰枪持续时间延长4秒。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 453,
//            "name": "告解之仪",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Rosaria_01.png",
//            "effect": "<color=#FFD780FF>噬罪的告解</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 454,
//            "name": "苦痛恩典",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Rosaria_03.png",
//            "effect": "<color=#FFD780FF>噬罪的告解</color>造成暴击时，为罗莎莉亚自己恢复5点元素能量。\\n每次噬罪的告解至多触发1次该效果。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 455,
//            "name": "临终祈礼",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Rosaria_02.png",
//            "effect": "<color=#FFD780FF>终命的圣礼</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 456,
//            "name": "代行裁判",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Rosaria_04.png",
//            "effect": "<color=#FFD780FF>终命的圣礼</color>的攻击会使敌人的物理抗性降低20%，持续10秒。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 3,
//        "costumes": [
//          {
//            "id": 204501,
//            "name": "致教会自由人",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/costume/UI_AvatarIcon_RosariaCostumeWic@2x.png"
//          }
//        ],
//        "external": null
//      },
//      {
//        "id": 10000062,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Aloy@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Aloy.png",
//        "name": "埃洛伊",
//        "element": "Cryo",
//        "fetter": 1,
//        "level": 20,
//        "rarity": 105,
//        "weapon": {
//          "id": 15416,
//          "name": "曚云之月",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Bow_Maria.png",
//          "type": 12,
//          "rarity": 4,
//          "level": 1,
//          "promote_level": 0,
//          "type_name": "弓",
//          "desc": "出自螺钿与珊瑚的精美战弓，月色的弓臂上流动着凄然的光彩。",
//          "affix_level": 1
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 621,
//            "name": "异界之星",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Aloy_Lock.png",
//            "effect": "点亮此人一方星空之刻尚未到来。",
//            "is_actived": false,
//            "pos": 1
//          },
//          {
//            "id": 622,
//            "name": "异界之星",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Aloy_Lock.png",
//            "effect": "点亮此人一方星空之刻尚未到来。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 623,
//            "name": "异界之星",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Aloy_Lock.png",
//            "effect": "点亮此人一方星空之刻尚未到来。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 624,
//            "name": "异界之星",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Aloy_Lock.png",
//            "effect": "点亮此人一方星空之刻尚未到来。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 625,
//            "name": "异界之星",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Aloy_Lock.png",
//            "effect": "点亮此人一方星空之刻尚未到来。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 626,
//            "name": "异界之星",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Aloy_Lock.png",
//            "effect": "点亮此人一方星空之刻尚未到来。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 0,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000015,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Kaeya@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Kaeya.png",
//        "name": "凯亚",
//        "element": "Cryo",
//        "fetter": 1,
//        "level": 20,
//        "rarity": 4,
//        "weapon": {
//          "id": 11402,
//          "name": "笛剑",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Sword_Troupe.png",
//          "type": 1,
//          "rarity": 4,
//          "level": 1,
//          "promote_level": 0,
//          "type_name": "单手剑",
//          "desc": "细剑的锈迹下透露出原本华丽的装饰，挥舞时轻若无物。",
//          "affix_level": 1
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 151,
//            "name": "卓越的血脉",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Kaeya_01.png",
//            "effect": "对受到<color=#99FFFFFF>冰元素</color>影响的敌人，凯亚的普通攻击与重击暴击率提升15%。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 152,
//            "name": "无尽的霜舞",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Kaeya_02.png",
//            "effect": "在<color=#FFD780FF>凛冽轮舞</color>的持续时间内击败敌人时，持续时间延长2.5秒，最多不会超过15秒。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 153,
//            "name": "凛冽的冰戏",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Kaeya_01.png",
//            "effect": "<color=#FFD780FF>霜袭</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 154,
//            "name": "极寒的轻吻",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Kaeya_03.png",
//            "effect": "凯亚的生命值低于20%时自动触发：\\n生成一个伤害吸收量等于生命值上限30%的护盾，持续20秒。\\n该护盾对<color=#99FFFFFF>冰元素伤害</color>有250%的吸收效果。\\n该效果每60秒只能触发一次。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 155,
//            "name": "至冷的拥抱",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Kaeya_02.png",
//            "effect": "<color=#FFD780FF>凛冽轮舞</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 156,
//            "name": "轮旋的冰凌",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Kaeya_04.png",
//            "effect": "<color=#FFD780FF>凛冽轮舞</color>会产生一个额外的寒冰之棱，并在施放时返还15点元素能量。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 2,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000044,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Xinyan@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Xinyan.png",
//        "name": "辛焱",
//        "element": "Pyro",
//        "fetter": 1,
//        "level": 20,
//        "rarity": 4,
//        "weapon": {
//          "id": 12405,
//          "name": "雨裁",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Claymore_Perdue.png",
//          "type": 11,
//          "rarity": 4,
//          "level": 1,
//          "promote_level": 0,
//          "type_name": "双手剑",
//          "desc": "散发着黯淡荧光的无锋大剑，纯粹以气势和力量碾碎敌人。",
//          "affix_level": 3
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 441,
//            "name": "绝命的加速",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xinyan_01.png",
//            "effect": "辛焱造成暴击后的5秒内，普通攻击和重击的攻击速度提升12%。\\n该效果每5秒只能触发一次。",
//            "is_actived": true,
//            "pos": 1
//          },
//          {
//            "id": 442,
//            "name": "开场即兴段",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xinyan_02.png",
//            "effect": "<color=#FFD780FF>叛逆刮弦</color>造成的物理伤害暴击率提升100%，并会在施放时形成三级护盾·舞遍节拍。",
//            "is_actived": true,
//            "pos": 2
//          },
//          {
//            "id": 443,
//            "name": "摭分的指法",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Xinyan_01.png",
//            "effect": "<color=#FFD780FF>热情拂扫</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 3
//          },
//          {
//            "id": 444,
//            "name": "节奏的传染",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xinyan_03.png",
//            "effect": "<color=#FFD780FF>热情拂扫</color>的挥舞伤害，会使敌人的物理抗性降低15%，持续12秒。",
//            "is_actived": true,
//            "pos": 4
//          },
//          {
//            "id": 445,
//            "name": "返场的高呼",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Xinyan_02.png",
//            "effect": "<color=#FFD780FF>叛逆刮弦</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": true,
//            "pos": 5
//          },
//          {
//            "id": 446,
//            "name": "地狱里摇摆",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Xinyan_04.png",
//            "effect": "辛焱的重击的体力消耗降低30%；此外，进行重击时，将基于防御力的50%获得攻击力加成。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 5,
//        "costumes": [],
//        "external": null
//      },
//      {
//        "id": 10000050,
//        "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Tohma@2x.png",
//        "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Tohma.png",
//        "name": "托马",
//        "element": "Pyro",
//        "fetter": 1,
//        "level": 20,
//        "rarity": 4,
//        "weapon": {
//          "id": 13409,
//          "name": "龙脊长枪",
//          "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Pole_Everfrost.png",
//          "type": 13,
//          "rarity": 4,
//          "level": 1,
//          "promote_level": 0,
//          "type_name": "长柄武器",
//          "desc": "利用龙之牙制成的长枪。有着奇异的温暖触感。",
//          "affix_level": 1
//        },
//        "reliquaries": [],
//        "constellations": [
//          {
//            "id": 501,
//            "name": "同袍的义理",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Tohma_01.png",
//            "effect": "处于托马自己的<color=#FFD780FF>烈烧佑命护盾</color>庇护下的角色（除了托马自己）受到攻击时，托马自己的<color=#FFD780FF>烈烧佑命之侍护</color>的冷却时间减少3秒，<color=#FFD780FF>真红炽火之大铠</color>的冷却时间减少3秒。\\n该效果每20秒至多触发一次。",
//            "is_actived": false,
//            "pos": 1
//          },
//          {
//            "id": 502,
//            "name": "僚佐的才巧",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Tohma_02.png",
//            "effect": "<color=#FFD780FF>真红炽火之大铠</color>的持续时间延长3秒。",
//            "is_actived": false,
//            "pos": 2
//          },
//          {
//            "id": 503,
//            "name": "御敌的执定",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Tohma_01.png",
//            "effect": "<color=#FFD780FF>烈烧佑命之侍护</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 3
//          },
//          {
//            "id": 504,
//            "name": "用臣的久计",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Tohma_03.png",
//            "effect": "施放<color=#FFD780FF>真红炽火之大铠</color>后，为托马恢复15点元素能量。",
//            "is_actived": false,
//            "pos": 4
//          },
//          {
//            "id": 505,
//            "name": "野火的豪烈",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Tohma_02.png",
//            "effect": "<color=#FFD780FF>真红炽火之大铠</color>的技能等级提高3级。\\n至多提升至15级。",
//            "is_actived": false,
//            "pos": 5
//          },
//          {
//            "id": 506,
//            "name": "炽烧的至心",
//            "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Tohma_04.png",
//            "effect": "获取或刷新<color=#FFD780FF>烈烧佑命护盾</color>时，队伍中所有角色的普通攻击，重击与下落攻击造成的伤害提升15%，持续6秒。",
//            "is_actived": false,
//            "pos": 6
//          }
//        ],
//        "actived_constellation_num": 0,
//        "costumes": [],
//        "external": null
//      }
//    ],
//    "role": {
//      "AvatarUrl": "",
//      "nickname": "major-tom",
//      "region": "cn_gf01",
//      "level": 56
//    }
//  }
//}