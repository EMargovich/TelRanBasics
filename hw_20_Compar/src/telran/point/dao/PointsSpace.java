package telran.point.dao;

import java.util.Arrays;
import java.util.Comparator;

import telran.point.model.Point;

public class PointsSpace {
	Point relPoint;
	Point[] points;
	Comparator<Point> comp = (p1, p2) -> {
		double proximity1 = proximity(relPoint, p1);
		double proximity2 = proximity(relPoint, p2);
		return Double.compare(proximity1, proximity2);
	};

	private static double proximity(Point p1, Point p2) {
		return Math.sqrt(Math.pow((p1.getX()-p2.getX()),2) + Math.pow(p1.getY()-p2.getY(),2));
	}

	public PointsSpace(Point relPoint, Point[] points) {
		this.relPoint = relPoint;
		Arrays.sort(points,comp);
		this.points = points;
	}

	public Point[] getPoints() {
		return points;
	}
	
	public void addPoint(Point point) {
		int index = Arrays.binarySearch(points, point, comp);
		if(index < 0) index = -index - 1;
			// Если индекс отрицательный, то он показывает, на какую позицию по порядку можно поставить элемент, начиная с 1.
		    // То есть поставить новый элемент нужно на место элемента с индексом на единицу меньше
			// Если индекс положительный, то он показывает, на каком индексе массива уже стоит искомый элемент.
			// Согласно представленному тесту, нужно вставить новый элемент на его место

		Point[] newPoints = new Point[points.length + 1];
		System.arraycopy(points, 0, newPoints, 0, index);
		newPoints[index] = point;
		System.arraycopy(points, index, newPoints, index + 1, points.length - index);
		this.points = newPoints;
	}
}
