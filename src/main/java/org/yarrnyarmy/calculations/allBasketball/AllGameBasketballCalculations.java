package org.yarrnyarmy.calculations.allBasketball;

import org.yarrnyarmy.model.AllBasketballGames.*;
import org.yarrnyarmy.services.allBasketballGames.AllBasketballGameServices;

import java.util.*;

public class AllGameBasketballCalculations {
    AllBasketballGameServices allGame = new AllBasketballGameServices();

    public List<BestTeams> getAllBestTeams() {
        List<BasketballAllGamePG> pg = allGame.getAllPG();
        List<BasketballAllGameSG> sg = allGame.getAllSG();
        List<BasketballAllGameSF> sf = allGame.getAllSF();
        List<BasketballAllGamePF> pf = allGame.getAllPF();
        List<BasketballAllGameC> pc = allGame.getAllC();
        List<BasketballAllGameG> gg = allGame.getAllG();
        List<BasketballAllGameF> ff = allGame.getAllF();
        List<BasketballAllGameUtil> util = allGame.getAllUtil();
        List<BestTeams> bestTeams = new ArrayList<>();

        for (int a = 0; a < pg.size(); a++) {
            for (int b = 0; b < sg.size(); b++) {
                if (pg.get(a).getPlayerDraftKingsId() != sg.get(b).getPlayerDraftKingsId()) {
                    for (int c = 0; c < sf.size(); c++) {
                        if (sg.get(b).getPlayerDraftKingsId() != sf.get(c).getPlayerDraftKingsId()) {
                            for (int d = 0; d < pf.size(); d++) {
                                if (sf.get(c).getPlayerDraftKingsId() != pf.get(d).getPlayerDraftKingsId()) {
                                    if (sf.get(c).getPlayerDraftKingsId() != sg.get(b).getPlayerDraftKingsId()) {
                                        for (int e = 0; e < pc.size(); e++) {
                                            if (pf.get(d).getPlayerDraftKingsId() != pc.get(e).getPlayerDraftKingsId()) {
                                                for (int f = 0; f < gg.size(); f++) {
                                                    if (pg.get(a).getPlayerDraftKingsId() != gg.get(f).getPlayerDraftKingsId()) {
                                                        if (sg.get(b).getPlayerDraftKingsId() != gg.get(f).getPlayerDraftKingsId()) {
                                                            if (sf.get(c).getPlayerDraftKingsId() != gg.get(f).getPlayerDraftKingsId()) {
                                                                for (int g = 0; g < ff.size(); g++) {
                                                                    if (sf.get(c).getPlayerDraftKingsId() != ff.get(g).getPlayerDraftKingsId()) {
                                                                        if (pf.get(d).getPlayerDraftKingsId() != ff.get(g).getPlayerDraftKingsId()) {
                                                                            if (pc.get(e).getPlayerDraftKingsId() != ff.get(g).getPlayerDraftKingsId()) {
                                                                                if (gg.get(f).getPlayerDraftKingsId() != ff.get(g).getPlayerDraftKingsId()) {
                                                                                    for (int h = 0; h < util.size(); h++) {
                                                                                        if (pg.get(a).getPlayerDraftKingsId() != util.get(h).getPlayerDraftKingsId()) {
                                                                                            if (sg.get(b).getPlayerDraftKingsId() != util.get(h).getPlayerDraftKingsId()) {
                                                                                                if (sf.get(c).getPlayerDraftKingsId() != util.get(h).getPlayerDraftKingsId()) {
                                                                                                    if (pf.get(d).getPlayerDraftKingsId() != util.get(h).getPlayerDraftKingsId()) {
                                                                                                        if (gg.get(f).getPlayerDraftKingsId() != util.get(h).getPlayerDraftKingsId()) {
                                                                                                            if (ff.get(g).getPlayerDraftKingsId() != util.get(h).getPlayerDraftKingsId()) {
                                                                                                                BestTeams bt = new BestTeams();
                                                                                                              if (pg.get(a).getSalary() + sg.get(b).getSalary() + sf.get(c).getSalary() + pf.get(d).getSalary() +
                                                                                                                        pc.get(e).getSalary() + gg.get(f).getSalary() + ff.get(g).getSalary() + util.get(h).getSalary() <= 50000) {

                                                                                                                    String name1 = pg.get(a).getFirstName() + " " + pg.get(a).getLastName();
                                                                                                                    String name2 = sg.get(b).getFirstName() + " " + sg.get(b).getLastName();
                                                                                                                    String name3 = sf.get(c).getFirstName() + " " + sf.get(c).getLastName();
                                                                                                                    String name4 = pf.get(d).getFirstName() + " " + pf.get(d).getLastName();
                                                                                                                    String name5 = pc.get(e).getFirstName() + " " + pc.get(e).getLastName();
                                                                                                                    String name6 = gg.get(f).getFirstName() + " " + gg.get(f).getLastName();
                                                                                                                    String name7 = ff.get(g).getFirstName() + " " + ff.get(g).getLastName();
                                                                                                                    String name8 = util.get(h).getFirstName() + " " + util.get(h).getLastName();
                                                                                                                    String totalName = name1 + " " + name2 + " " + name3 + " " + name4 + " " +
                                                                                                                            name5 + " " + name6 + " " + name7 + " " + name8;

                                                                                                                    int salary1 = pg.get(a).getSalary();
                                                                                                                    int salary2 = sg.get(b).getSalary();
                                                                                                                    int salary3 = sf.get(c).getSalary();
                                                                                                                    int salary4 = pf.get(d).getSalary();
                                                                                                                    int salary5 = pc.get(e).getSalary();
                                                                                                                    int salary6 = gg.get(f).getSalary();
                                                                                                                    int salary7 = ff.get(g).getSalary();
                                                                                                                    int salary8 = util.get(h).getSalary();
                                                                                                                    int totalSalary = salary1 + salary2 + salary3 + salary4 + salary5 + salary6 +
                                                                                                                            salary7 + salary8;

                                                                                                                    double fPoints1 = pg.get(a).getDraftKingsFantasyPoints();
                                                                                                                    double fPoints2 = sg.get(b).getDraftKingsFantasyPoints();
                                                                                                                    double fPoints3 = sf.get(c).getDraftKingsFantasyPoints();
                                                                                                                    double fPoints4 = pf.get(d).getDraftKingsFantasyPoints();
                                                                                                                    double fPoints5 = pc.get(e).getDraftKingsFantasyPoints();
                                                                                                                    double fPoints6 = gg.get(f).getDraftKingsFantasyPoints();
                                                                                                                    double fPoints7 = ff.get(g).getDraftKingsFantasyPoints();
                                                                                                                    double fPoints8 = util.get(h).getDraftKingsFantasyPoints();
                                                                                                                    double totalFantasyPoints = fPoints1 + fPoints2 + fPoints3 + fPoints4 +
                                                                                                                            fPoints5 + fPoints6 + fPoints7 + fPoints8;
                                                                                                                    if (totalFantasyPoints > 200) {
                                                                                                                        bt.setNames(totalName);
                                                                                                                        bt.setTotalSalary(totalSalary);
                                                                                                                        bt.setTotalFantasyPoints(totalFantasyPoints);
                                                                                                                        if (bestTeams.size() < 20000000) {
                                                                                                                            bestTeams.add(bt);
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(bestTeams, Comparator.comparingDouble(BestTeams::getTotalFantasyPoints));
        Collections.reverse(bestTeams);

        return bestTeams;
    }
}
