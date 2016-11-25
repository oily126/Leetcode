public class Solution {
    class Building {
        int left;
        int right;
        int height;
        public Building(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
        public Building(int[] building) {
            this.left = building[0];
            this.right = building[1];
            this.height = building[2];
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        int num = buildings.length;
        List<Building> buildingList = new ArrayList<>(num);
        for (int[] building : buildings) {
            buildingList.add(new Building(building));
        }
        Collections.sort(buildingList, new Comparator<Building>() {
            public int compare(Building a, Building b) {
                if (a.left != b.left) return a.left - b.left;
                return b.height - a.height;
            }
        });
        
        PriorityQueue<Integer> rightLines = new PriorityQueue<>(10,
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    if (buildingList.get(a.intValue()).right != buildingList.get(b.intValue()).right) {
                        return buildingList.get(a.intValue()).right - buildingList.get(b.intValue()).right;
                    }
                    return buildingList.get(a.intValue()).height - buildingList.get(b.intValue()).height;
                }
            });
        TreeSet<Building> curBuildings = new TreeSet<>(new Comparator<Building>() {
            public int compare(Building a, Building b) {
                if (a.height != b.height) return a.height - b.height;
                if (a.left != b.left) return a.left - b.left;
                return a.right - b.right;
            }
        });
        Integer lastHeight = 0;
        int cnt = 0;
        List<int[]> skyLines = new ArrayList<>();
        for (int i = 0; i < buildingList.size(); i++) {
            Building building = buildingList.get(i);
            //System.out.println(curBuildings.size());
            while (!rightLines.isEmpty()) {
                Integer index = rightLines.peek();
                if (building.left > buildingList.get(index).right) {
                    rightLines.poll();
                    curBuildings.remove(buildingList.get(index));
                    if (curBuildings.size() > 0) {
                        if (curBuildings.last().height < lastHeight && buildingList.get(index).height == lastHeight) {
                            lastHeight = curBuildings.last().height;
                            skyLines.add(new int[] {buildingList.get(index).right, lastHeight});
                        }
                    } else {
                        skyLines.add(new int[] {buildingList.get(index).right, 0});
                        lastHeight = 0;
                        break;
                    }
                } else {
                    break;
                }
            }
            curBuildings.add(building);
            rightLines.offer(cnt++);
            if (curBuildings.last().height > lastHeight) {
                lastHeight = curBuildings.last().height;
                skyLines.add(new int[] {building.left, lastHeight});
            }
            
        }
        while (!rightLines.isEmpty()) {
            Integer index = rightLines.poll();
            curBuildings.remove(buildingList.get(index));
            //System.out.println(curBuildings.size());
            if (curBuildings.size() > 0) {
                if (curBuildings.last().height < lastHeight && buildingList.get(index).height == lastHeight) {
                    lastHeight = curBuildings.last().height;
                    skyLines.add(new int[] {buildingList.get(index).right, lastHeight});
                }
            } else {
                skyLines.add(new int[] {buildingList.get(index).right, 0});
                lastHeight = 0;
                break;
            }
        }
        return skyLines;
    }
}